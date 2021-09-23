package com.dbs.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.model.Message;
import com.dbs.spring.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository repo;
	
	public List<Message> getAllMessages(){
		List<Message> messages = new ArrayList<>();
		repo.findAll().forEach(i->messages.add(i));
		return messages;
	}
	
	public Message getMessageByCode(String Code) {
		Optional<Message> message = repo.findById(Code);
		if(message.isPresent()) {
			return message.get();
		}
		return null;
	}
	
}
