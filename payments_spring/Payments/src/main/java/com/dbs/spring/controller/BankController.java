package com.dbs.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.model.Bank;
import com.dbs.spring.service.BankService;

@RestController
@RequestMapping("/bank")
@CrossOrigin
public class BankController {

	@Autowired
	private BankService service;
	
	@GetMapping("")
	public ResponseEntity<Object> getAllBanks(){
		try {
			List<Bank> banks = service.getAllBanks();
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponsePage(true, banks, "Success"));
		}catch(Exception e) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponsePage(false, null, "Something went wrong with error : " + e.getMessage()));			
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getBankById(@PathVariable String id){
		Bank bank = service.getBankWithId(id);
		if(bank==null) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponsePage(false, null, "No bank exists with id : "+id));
		}else {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponsePage(true, bank, "Success"));
		}
	}
	
}
