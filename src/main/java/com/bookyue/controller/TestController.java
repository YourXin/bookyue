package com.bookyue.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookyue.util.CheckContent;

@RestController
public class TestController {

	Map<String, Object> resultMap = new HashMap<String, Object>();

	@Autowired
	private CheckContent checkContent;

	@GetMapping("/test1")
	public Map<String, Object> testGetAccessToken() {
		resultMap.put("result", "hello");
		resultMap.put("success", true);
		resultMap.put("msg", "hello");
		
		return resultMap;
	}

}
