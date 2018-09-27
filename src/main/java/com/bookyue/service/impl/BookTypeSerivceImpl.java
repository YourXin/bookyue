package com.bookyue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookyue.mapper.BookTypeMapper;
import com.bookyue.model.BookType;
import com.bookyue.model.BookTypeExample;
import com.bookyue.service.BookTypeSerivce;

@Service
public class BookTypeSerivceImpl implements BookTypeSerivce {
	@Autowired
	private BookTypeMapper bookTypeMapper;

	@Override
	public List<BookType> getAll() {

		BookTypeExample example = new BookTypeExample();
		example.setOrderByClause("type_id ASC");
		return bookTypeMapper.selectByExample(example);
	}

}
