package com.dgit.ex02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dgit.domain.MessageVO;
import com.dgit.persistence.MessageDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MessageDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(MessageDAOTest.class);
	
	@Autowired
	MessageDAO dao;

	
	@Test
	public void testCreate() throws Exception{
		MessageVO vo = new MessageVO();
		vo.setSender("user02");
		vo.setTargetid("user02");
		vo.setMessage("안녕2");
		dao.create(vo);
	}
	
	//@Test
	public void testReadMessage() throws Exception{

		logger.info(dao.readMessage(2).toString());
	}
	
	//@Test
	public void testUpdateState() throws Exception{

		dao.updateState(2);
		testReadMessage();
	}
	
	
}













