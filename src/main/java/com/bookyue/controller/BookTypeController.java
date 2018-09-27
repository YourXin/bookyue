package com.bookyue.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookyue.service.BookTypeSerivce;

/**
 * 书籍分类信息
 * 
 * @author bigOrang
 *
 */
@RestController
@RequestMapping(value = "/bookType")
public class BookTypeController {
	@Autowired
	private BookTypeSerivce bookTypeService;

	/**
	 * 得到所有的分类信息
	 * @return
	 */
	@GetMapping(value = "/getAll")
	public Map<String, Object> getAll() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bookTypeList", bookTypeService.getAll());
		return map;
	}
}
