package com.bookyue.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookyue.model.JSONResult;
import com.bookyue.model.Messages;

@RestController
@RequestMapping("/msg")
public class MessagesController {

	
	
	@PostMapping("/send")
	public JSONResult send(Messages messages) {
		
		
		return JSONResult.build(200,"发送成功",null);
	}
}
