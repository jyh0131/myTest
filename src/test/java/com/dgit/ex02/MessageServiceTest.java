package com.dgit.ex02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dgit.domain.MessageVO;
import com.dgit.service.MessageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MessageServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(MessageServiceTest.class);
	
	@Autowired
	MessageService service;
	
	@Test
	public void testAddMessage() throws Exception{
		MessageVO vo = new MessageVO();
		vo.setTargetid("user02");
		vo.setSender("user01");
		vo.setMessage("테스트입니다.1-2.");
		service.addMessage(vo);
		//1. message table에 메시지 추가
		//2. user01의 point 10추가되어야 함.
	}
	
	@Test
	public void testReadMessage() throws Exception{
		service.readMessage("user02", 5);	
		//1. message의 read시간이 update되어야 됨
		//2. user02의 point 5추가되어야 함.
	}	
}








