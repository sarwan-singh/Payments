package com.dbs.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.model.Bank;
import com.dbs.spring.model.Message;
import com.dbs.spring.service.MessageService;

@RestController
@RequestMapping("/message")
@CrossOrigin
public class MessageController {

	@Autowired
	private MessageService service;
	
	@GetMapping("")
	public ResponseEntity<Object> getAllMessage(){
		try {
			List<Message> messages = service.getAllMessages();
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponsePage(true, messages, "Success"));
		}catch(Exception e) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponsePage(false, null, "Something went wrong with error : " + e.getMessage()));			
		}
	}
	
}
