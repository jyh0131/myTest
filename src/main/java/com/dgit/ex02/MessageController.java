package com.dgit.ex02;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dgit.domain.MessageVO;
import com.dgit.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Inject
	private MessageService service;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> addMessage(@RequestBody MessageVO vo) {
		logger.info("messages POST ........");
		
		ResponseEntity<String> entity = null;
		//test1
		
		try {
			service.addMessage(vo);
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/{mid}", method=RequestMethod.GET)
	public ResponseEntity<MessageVO> readMessage(String userid, @PathVariable("mid") int mid) {
		logger.info("messages POST ........");
		
		ResponseEntity<MessageVO> entity = null;
		
		try {
			MessageVO vo =service.readMessage(userid, mid);
			entity = new ResponseEntity<>(vo, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity = new ResponseEntity<>( HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}















