package com.dbs.spring.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dbs.spring.controller.ResponsePage;

@Service
public class ResponseEntityService {

	public ResponseEntity<ResponsePage> createResponseEntity(HttpStatus statusCode, boolean status, Object data, String message){
		return ResponseEntity
				.status(statusCode)
				.body(new ResponsePage(status, data, message));
	}
	
}
