package com.bookyue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookyue.mapper.BookCollectMapper;
import com.bookyue.mapper.BookPublishMapper;
import com.bookyue.model.BookCollect;
import com.bookyue.model.BookCollectCustom;
import com.bookyue.model.BookCollectExample;
import com.bookyue.model.BookPublish;
import com.bookyue.service.BookCollectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class BookCollectServiceImpl implements BookCollectService {

	@Autowired
	private BookCollectMapper bookCollectMapper;

	@Autowired
	private BookPublishMapper bookPublishMapper;

	@Override
	public boolean addBookCollect(BookCollect bookCollect) {
		try {
			if (bookCollect.getBookId() != null && bookCollect.getUserId() != null) {
				BookPublish bookPublish = bookPublishMapper.selectByPrimaryKey(bookCollect.getBookId());
				if (bookPublish != null) {
					// 查询书籍的信息,然后设置bookCollect属性
					bookCollect.setBookName(bookPublish.getBookName());
					bookCollect.setBookPicPath(bookPublish.getBookPicPath());
					bookCollect.setBookPrimePrice(bookPublish.getBookPrimePrice());
					bookCollect.setBookSellPrice(bookPublish.getBookSellPrice());
					return bookCollectMapper.insert(bookCollect) == 1 ? true : false;
				} else {
					// 没有找到BookId这本书
					return false;
				}
			} else {
				// 传入的数据不完整
				return false;
			}
		} catch (Exception e) {
			throw new RuntimeException("bookCollect数据库插入失败" + e.toString());
		}
	}

	/**
	 * 通过书籍的收藏记录id来查询记录
	 */
	@Override
	public BookCollect getByCollectId(Integer coolectId) {
		if (coolectId != null) {
			return bookCollectMapper.selectByPrimaryKey(coolectId);
		}
		return null;
	}

	@Override
	public boolean isExist(Integer userId, Integer bookId) {
		if (userId != null && bookId != null) {
			BookCollectExample bookCollectExample = new BookCollectExample();
			bookCollectExample.createCriteria().andBookIdEqualTo(bookId).andUserIdEqualTo(userId);
			// 有记录则返回true,否则返回false
			return bookCollectMapper.selectByExample(bookCollectExample).size() == 1 ? true : false;
		}
		return false;
	}

	@Override
	public boolean deleteBookCollect(Integer id, Integer userId) {
		if (userId != null && userId != null) {
			BookCollectExample bookCollectExample = new BookCollectExample();
			bookCollectExample.createCriteria().andIdEqualTo(id).andUserIdEqualTo(userId);
			if (bookCollectMapper.deleteByExample(bookCollectExample) == 1) {
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public List<BookCollectCustom> getListByUserId(Integer userId) {
		if (userId != null) {
			return bookCollectMapper.selectByUserId(userId);
		} else {
			throw new RuntimeException("userId == null");
		}
	}

	@Override
	public PageInfo<BookCollectCustom> getListByUserId(int pageNum, Integer userId) {
		PageHelper.startPage(pageNum, 15);
		List<BookCollectCustom> list = bookCollectMapper.selectByUserId(userId);
		PageInfo<BookCollectCustom> pageInfo = new PageInfo<BookCollectCustom>(list);
		return pageInfo;
	}

	@Override
	public boolean deleteBookCollectByBookIdAndUserId(Integer bookId, Integer userId) {
		if (bookId != null && userId != null) {
			BookCollectExample bookCollectExample = new BookCollectExample();
			bookCollectExample.createCriteria().andBookIdEqualTo(bookId).andUserIdEqualTo(userId);
			if (bookCollectMapper.deleteByExample(bookCollectExample) == 1) {
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public BookCollect getByUserIdAndBookId(Integer bookId, Integer userId) {

		BookCollectExample bookCollectExample = new BookCollectExample();
		bookCollectExample.createCriteria().andBookIdEqualTo(bookId).andUserIdEqualTo(userId);
		List<BookCollect> list = bookCollectMapper.selectByExample(bookCollectExample);
		if (list.size() != 0) {
			return list.get(0);
		}
		return null;
	}

}
