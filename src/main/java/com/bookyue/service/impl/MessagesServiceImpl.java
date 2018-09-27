package com.bookyue.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookyue.mapper.MessagesMapper;
import com.bookyue.model.Messages;
import com.bookyue.service.MessagesService;
import com.github.pagehelper.PageInfo;

@Service
public class MessagesServiceImpl implements MessagesService {

	@Autowired
	private MessagesMapper messagesMapper;

	@Override
	public boolean addMessages(Messages messages) {
		messages.setMsgTime(new Date());
		messages.setMsgStatus((byte)2);
		int result = messagesMapper.insert(messages);
		if (result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delMessagesById(Integer msgId) {
		
		return false;
	}

	@Override
	public PageInfo<Messages> queryByFromUserIdAndToUserId(Integer fromUserId, Integer toUserId, Integer pageNum) {
		return null;
	}

}