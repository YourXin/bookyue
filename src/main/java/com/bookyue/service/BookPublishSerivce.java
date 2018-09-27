package com.bookyue.service;

import com.bookyue.model.BookPublish;
import com.bookyue.model.BookPublishCustom;
import com.github.pagehelper.PageInfo;

public interface BookPublishSerivce {

	/**
	 * 添加/发布一本书
	 * 
	 * @param bookPublish
	 * @return
	 */
	boolean addBookPublish(BookPublish bookPublish);

	/**
	 * 根据userId和bookId来删除匹配的书籍<br>
	 * 删除时需满足当前书籍无正在交易的订单<br>
	 * 必须完成订单后才能删除<br>
	 * 
	 * @param userId
	 * @param bookId
	 * @return 删除成功返回true,删除失败返回false
	 */
	boolean deleteBookPublish(Integer userId, Integer bookId);

	/**
	 * 修改书籍信息
	 * @param bookPublish
	 * @return
	 */
	boolean updateBookPublish(BookPublish bookPublish);

	/**
	 * 
	 * 使用分页,多条件模糊查询符合的数据
	 * 类型id使用唯一匹配
	 * /书名/ISBN/出版社/作者做模糊查询
	 * 
	 * @param page
	 * @param bookPublish
	 * @return
	 */
	PageInfo<BookPublish> getBookPublishList(int page, BookPublish bookPublish);

	/**
	 * 使用一个关键字查询出数据并做分页
	 * 
	 * 关键字去匹配书名/作者/ISBN/出版社. 
	 * 输入书名/作者/ISBN/出版社进行模糊查询
	 * 
	 * @param pageNum 目标页
	 * @param bookPublish 查询条件
	 * @return
	 */
	// PageInfo<BookPublish> getBookPublishList(int pageNum, Byte bookTypeId, String
	// keyword);

	/**
	 * 根据userId来查询自己的订单
	 * @param pageNum
	 * @param userId
	 * @return
	 */
	PageInfo<BookPublish> getMyBookPublishList(int pageNum, BookPublish bookPublish);

	/**
	 * 使用一个关键字查询出数据并做分页
	 * 
	 * 关键字去匹配书名/作者/ISBN/出版社. 
	 * 输入书名/作者/ISBN/出版社进行模糊查询
	 * 
	 * @param pageNum    分页的目标页
	 * @param bookTypeId 书籍类型id
	 * @param keyword    输入的关键词
	 * @return PageInfo<BookPublishCustom>
	 */
	PageInfo<BookPublishCustom> getBookPublishCustomList(int pageNum, Byte bookTypeId, String keyword);

	/**
	 * 根据已发布的书籍的bookId来查询出书籍信息
	 * @param bookId
	 * @return BookPublish
	 */
	BookPublish getByBookId(Integer bookId);

	/**
	 * 根据bookId和userId来查询一条记录
	 * @param bookId
	 * @param userId
	 * @return BookPublish
	 */
	BookPublish getByBookIdAndUserId(Integer bookId, Integer userId);

	/**
	 * 根据已发布的书籍的bookId来查询出书籍信息<br>
	 * 且包含发布者的昵称、头像图片地址、性别
	 * @param bookId
	 * @return
	 */
	BookPublishCustom getBookPublishCustomByBookId(Integer bookId);
	
	
	
}
