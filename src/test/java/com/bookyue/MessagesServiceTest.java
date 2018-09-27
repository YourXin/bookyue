package com.bookyue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookyue.model.Messages;
import com.bookyue.service.MessagesService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MessagesServiceTest {

	@Autowired
	private MessagesService messagesService;
	
	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void test() {
		
		System.out.println(222);
	}
	
	
	@Test
	public void testAddMessages() {
		Messages msgs = new Messages();
		msgs.setMsgContent("HelloWorld");
		msgs.setMsgFromUserid(2);
		msgs.setMsgToUserid(3);
		messagesService.addMessages(msgs);
	}
	

}
