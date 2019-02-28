package com.bookyue.model;

import java.util.List;

public class BookPublishCustom extends BookPublish{

	/**
	 * 书籍基本信息
	 */
	private BookPublish bookPublish;
	
	/**
	 * 发布者信息
	 */
	private UserInfo userInfo;
	
	
	/**
	 * 书籍的评论信息
	 */
	private List<BookCommentCustom> commentList;


	public BookPublish getBookPublish() {
		return bookPublish;
	}


	public void setBookPublish(BookPublish bookPublish) {
		this.bookPublish = bookPublish;
	}


	public UserInfo getUserInfo() {
		return userInfo;
	}


	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}


	public List<BookCommentCustom> getCommentList() {
		return commentList;
	}


	public void setCommentList(List<BookCommentCustom> commentList) {
		this.commentList = commentList;
	}
	
}
