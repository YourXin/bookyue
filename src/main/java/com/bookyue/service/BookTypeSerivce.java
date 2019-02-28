package com.bookyue.service;

import java.util.List;

import com.bookyue.model.BookType;

/**
 * 书籍分类信息
 * @author BigOrang
 *
 */
public interface BookTypeSerivce {

	/**
	 * 得到所有的分类信息
	 * @return
	 */
	List<BookType> getAll();
	
	
	
}
