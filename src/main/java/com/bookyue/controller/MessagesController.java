package com.bookyue.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookyue.model.JSONResult;
import com.bookyue.model.Messages;
import com.bookyue.model.UserInfo;

@RestController
@RequestMapping("/msg")
public class MessagesController {

	@PostMapping("/send")
	public JSONResult send(Messages messages) {
		UserInfo user = new UserInfo();
		user.setUserName("HelloWorld");
		user.setUserPhone("13906050302");
		return JSONResult.build(200, "发送成功", null);
	}

	@GetMapping("/test")
	public JSONResult test(Messages messages) {
		UserInfo user = new UserInfo();
		user.setUserName("HelloWorld");
		user.setUserPhone("13906050302");
		return JSONResult.build(200, "发送成功", user);
	}

}
