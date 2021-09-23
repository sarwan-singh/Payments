package com.dbs.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.model.Currency;
import com.dbs.spring.repository.CurrencyRepository;

@RestController
@RequestMapping("/currency")
@CrossOrigin
public class CurrencyController {

	@Autowired
	private CurrencyRepository repository;
	
	@GetMapping
	public ResponseEntity<Object> getAllCurrencies(){
		List<Currency> currencies = new ArrayList<>();
		try {
			repository.findAll().forEach(i->currencies.add(i));
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponsePage(true, currencies, "Success"));
		}catch(Exception e) {
			
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponsePage(false, currencies, "Something went wrong" ));
		}
		
	}
}
