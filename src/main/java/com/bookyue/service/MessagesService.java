package com.bookyue.service;

import com.bookyue.model.Messages;
import com.github.pagehelper.PageInfo;

/**
 * 聊天消息
 * @author bigOrang
 *
 */
public interface MessagesService {
	
	/**
	 * 添加一条消息内容
	 * @param messages
	 * @return
	 */
	boolean addMessages(Messages messages);
	
	/**
	 * 
	 * 删除一条消息内容
	 * @param msgId
	 * @return
	 */
	boolean delMessagesById(Integer msgId);
	
//	List<Messages> queryByFromUserIdAndToUserId(Integer fromUserId,Integer toUserId);
	
	/**
	 * 根据发送人和接受者的用户id 来分页 查询消息记录
	 * @param fromUserId
	 * @param toUserId
	 * @param pageNum
	 * @return
	 */
	PageInfo<Messages> queryByFromUserIdAndToUserId(Integer fromUserId,Integer toUserId, Integer pageNum);
	
	

}
