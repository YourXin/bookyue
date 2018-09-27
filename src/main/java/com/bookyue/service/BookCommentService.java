package com.bookyue.service;

import java.util.List;

import com.bookyue.model.BookComment;
import com.bookyue.model.BookCommentCustom;

/**
 * 书籍评论
 * @author bigOrang
 * @version 1.0 
 *
 */
public interface BookCommentService {

	/**
	 * 添加一条评论
	 * @param bookComment
	 * @return
	 */
	boolean addBookComment(BookComment bookComment);

	/**
	 * 通过commentId 删除一条评论记录
	 * @param commentId
	 * @return
	 */
	boolean deleteByCommentId(Integer commentId);
	
	/**
	 * 根据书籍编号commentBookId 来查询对应书籍相关的评论
	 * 查询结果包含评论者的头像和用户名和性别
	 * @param commentBookId
	 * @return
	 */
	List<BookCommentCustom> getBookCommentCustomListByBookId(Integer commentBookId);
}
