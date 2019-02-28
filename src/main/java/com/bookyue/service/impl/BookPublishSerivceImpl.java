package com.bookyue.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookyue.mapper.BookCommentMapper;
import com.bookyue.mapper.BookPublishMapper;
import com.bookyue.mapper.OrderInfoMapper;
import com.bookyue.mapper.UserInfoMapper;
import com.bookyue.model.BookPublish;
import com.bookyue.model.BookPublishCustom;
import com.bookyue.model.BookPublishExample;
import com.bookyue.model.BookPublishExample.Criteria;
import com.bookyue.model.OrderInfo;
import com.bookyue.model.OrderInfoExample;
import com.bookyue.model.UserInfo;
import com.bookyue.service.BookPublishSerivce;
import com.bookyue.util.MyStringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class BookPublishSerivceImpl implements BookPublishSerivce {

	@Autowired
	private BookPublishMapper bookPublishMapper;

	@Autowired
	private OrderInfoMapper orderInfoMapper;

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Autowired
	private BookCommentMapper bookCommentMapper;

	@Transactional
	@Override
	public boolean addBookPublish(BookPublish bookPublish) {
		try {
			// 不考虑发布类型
			if (bookPublish.getPublishType() == null) {
				bookPublish.setPublishType((byte) 1);
			}

			String userPhone = userInfoMapper.selectByPrimaryKey(bookPublish.getUserId()).getUserPhone();
			// 当前没有手机号
			if (MyStringUtil.isEmpty(userPhone)) {
				return false;
			}
			// 设置发布的时间
			bookPublish.setPublishTime(new Date());
			int effectNum = bookPublishMapper.insertSelective(bookPublish);
			if (effectNum > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new RuntimeException("添加书籍信息失败" + e.getMessage());
		}
	}

	@Override
	public BookPublish getByBookId(Integer bookId) {
		return bookPublishMapper.selectByPrimaryKey(bookId);
	}

	@Override
	public PageInfo<BookPublish> getBookPublishList(int page, BookPublish bookPublish) {
		PageHelper.startPage(page, 15);

		BookPublishExample bookPublishExample = new BookPublishExample();
		if (bookPublish == null || bookPublish.getUserId() == null) {
			// 返回空的pageInfo
			return new PageInfo<>();
		}
		// 设置类型id/书名/ISBN/出版社/作者
		Criteria criteria = bookPublishExample.createCriteria();
		// 设置书籍类型id
		if (bookPublish.getBookTypeId() != null) {
			criteria.andBookTypeIdEqualTo(bookPublish.getBookTypeId());
		}
		// 设置出版社
		if (bookPublish.getBookPublisher() != null) {
			criteria.andBookPublisherLike(bookPublish.getBookPublisher());
		}
		// 设置bookName
		if (bookPublish.getBookName() != null) {
			criteria.andBookNameLike("%" + bookPublish.getBookName() + "%");
		}
		// 设置ISBN
		if (bookPublish.getBookIsbn() != null) {
			criteria.andBookIsbnEqualTo(bookPublish.getBookIsbn());
		}
		// 设置作者
		if (bookPublish.getBookAuthor() != null) {
			criteria.andBookAuthorEqualTo(bookPublish.getBookAuthor());
		}

		bookPublishExample.setOrderByClause("publish_time DESC");
		List<BookPublish> list = bookPublishMapper.selectByExample(bookPublishExample);
		PageInfo<BookPublish> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	/**
	 * 根据bookId查询出书籍信息、发布者基本信息
	 * <p>发布者基本信息:用户头像路径、用户名、id、性别、电话号码</p>
	 */
	@Override
	public BookPublishCustom getBookPublishCustomByBookId(Integer bookId) {

		BookPublishCustom bookPublishCustom = new BookPublishCustom();
		// 查询书籍基本信息
		BookPublish bookPublish = bookPublishMapper.selectByPrimaryKey(bookId);
		if (bookPublish != null) {
			// 设置书籍信息
			bookPublishCustom.setBookPublish(bookPublish);
			// 查询发布者信息
			UserInfo userInfo = userInfoMapper.selectByPrimaryKey(bookPublish.getUserId());

			UserInfo tempUserInfo = new UserInfo();
			tempUserInfo.setUserAvatarUrl(userInfo.getUserAvatarUrl());
			tempUserInfo.setUserName(userInfo.getUserName());
			tempUserInfo.setUserSex(userInfo.getUserSex());
			tempUserInfo.setUserId(userInfo.getUserId());
			tempUserInfo.setUserPhone(userInfo.getUserPhone());
			// 设置发布者信息
			bookPublishCustom.setUserInfo(tempUserInfo);

//			List<BookCommentCustom> commentList = bookCommentMapper.selectByCommentBookId(bookId);
			
		}

		return bookPublishCustom;

	}

	@Override
	public PageInfo<BookPublishCustom> getBookPublishCustomList(int page, Byte bookTypeId, String keyword) {
		PageHelper.startPage(page, 15);
		BookPublishExample bookPublishExample = new BookPublishExample();
		Criteria criteria = bookPublishExample.createCriteria();
		// 前端传0代表查询所有的
		if (bookTypeId != 0) {
			criteria.andBookTypeIdEqualTo(bookTypeId);
		}
		if (keyword != null && !"".equals(keyword)) {
			// 设置出版社,第一个设置为criteria.and
			criteria.andBookPublisherLike("%" + keyword + "%");
			// 设置bookName
			bookPublishExample.or().andBookNameLike("%" + keyword + "%");
			// 设置ISBN
			bookPublishExample.or().andBookIsbnLike("%" + keyword + "%");
			// 设置作者
			bookPublishExample.or().andBookAuthorLike("%" + keyword + "%");
		}

		// 按发布时间降序时间排序
		bookPublishExample.setOrderByClause("publish_time DESC");
		List<BookPublishCustom> list = bookPublishMapper.selectBookPublishCustomByExample(bookPublishExample);
		PageInfo<BookPublishCustom> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public boolean deleteBookPublish(Integer userId, Integer bookId) {
		if (userId != null && bookId != null) {
			OrderInfoExample orderInfoExample = new OrderInfoExample();

			List<Byte> statusList = new ArrayList<Byte>();
			statusList.add((byte) 1);
			statusList.add((byte) 2);
			orderInfoExample.createCriteria().andBookIdEqualTo(bookId).andStatusIn(statusList);
			List<OrderInfo> list = orderInfoMapper.selectByExample(orderInfoExample);
			if (list.size() > 0) {
				throw new RuntimeException("当前存在未完成的订单");
			}
			BookPublishExample bookPublishExample = new BookPublishExample();
			bookPublishExample.createCriteria().andBookIdEqualTo(bookId).andUserIdEqualTo(userId);
			int effectNum = bookPublishMapper.deleteByExample(bookPublishExample);
			return effectNum == 1 ? true : false;
		} else {
			throw new RuntimeException("deleteBookPublish()...userId:" + userId + ",bookId: " + bookId);
		}
	}

	@Override
	public boolean updateBookPublish(BookPublish bookPublish) {

		try {
			// 目前不考虑发布类型,手动设置发布类型
			if (bookPublish.getPublishType() == null) {
				bookPublish.setPublishType((byte) 1);
			}
			bookPublish.setPublishTime(new Date());// 设置发布的时间
			int effectNum = bookPublishMapper.updateByPrimaryKey(bookPublish);
			return effectNum == 1 ? true : false;
		} catch (Exception e) {
			throw new RuntimeException("更新书籍信息失败" + e.getMessage());
		}
	}

	@Override
	public BookPublish getByBookIdAndUserId(Integer bookId, Integer userId) {
		if (userId != null && bookId != null) {
			BookPublishExample bookPublishExample = new BookPublishExample();
			bookPublishExample.createCriteria().andBookIdEqualTo(bookId).andUserIdEqualTo(userId);
			return bookPublishMapper.selectByExample(bookPublishExample).get(0);
		} else {
			throw new RuntimeException("getByBookIdAndUserId()...userId" + userId + ",bookId:" + bookId);
		}
	}

	@Override
	public PageInfo<BookPublish> getMyBookPublishList(int pageNum, BookPublish bookPublish) {

		if (bookPublish == null || bookPublish.getUserId() == null) {
			return null;
		}
		
		BookPublishExample bookPublishExample = new BookPublishExample();
		bookPublishExample.createCriteria().andUserIdEqualTo(bookPublish.getUserId());
		bookPublishExample.setOrderByClause("publish_time DESC");
		PageInfo<BookPublish> pageInfo = new PageInfo<BookPublish>(
				bookPublishMapper.selectByExample(bookPublishExample));
		return pageInfo;
	}
}
