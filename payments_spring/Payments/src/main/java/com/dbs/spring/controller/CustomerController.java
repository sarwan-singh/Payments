package com.dbs.spring.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.model.Customer;
import com.dbs.spring.service.CustomerService;
import com.dbs.spring.service.CustomerUserService;
import com.dbs.spring.service.JwtService;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@Autowired
	private CustomerUserService userService;
	
	@Autowired
	private JwtService jwtService;
	
	@GetMapping("/user")
	public ResponseEntity<Object> getCustomerByCustomerid(){
		try {
			Customer customer = userService.getCustomerByUserName(jwtService.getUserNameFromSecurity());
			if(customer==null) {
				return ResponseEntity
						.status(HttpStatus.BAD_REQUEST)
						.body(new ResponsePage(false, customer, "Customer doesn't exist with the provided username"));
			}else {
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(new ResponsePage(true, customer, "Success"));
			}
		}catch(Exception e) {
			
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body(new ResponsePage(false, null, "Token is expired or invalid"));		}
	}
	
//	@GetMapping("")
//	public ResponseEntity<Object> getAllCustomers(){
//		try {
//			List<Customer> customers = service.getAllCustomers();
//			return ResponseEntity
//					.status(HttpStatus.OK)
//					.body(new ResponsePage(true, customers, "Success"));
//					
//		}catch(Exception e) {
//			return ResponseEntity
//					.status(HttpStatus.OK)
//					.body(new ResponsePage(false, null, "Something went wrong"));
//		}
//
//	}
	
	@GetMapping("/type")
	public ResponseEntity<Object> checkUser(@RequestParam String id, @RequestParam char type){
		Customer customer = service.getCustomerById(id);
		if(customer==null) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ResponsePage(false, customer, "Customer doesn't exist with the provided id"));
		}else {
			boolean status = service.checkUser(id, type);
			if(status) {
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(new ResponsePage(true, customer, "Customer is of type "+type));
			}else {
				return ResponseEntity
						.status(HttpStatus.BAD_REQUEST)
						.body(new ResponsePage(false, customer, "Customer is of type "+type));
			}
		}
	}
	
	@GetMapping("/checkBlacklist/{name}")
	public ResponseEntity<Object> checkBlacklist(@PathVariable String name){
		try {
			if(service.checkSdnList(name)) {
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(new ResponsePage(false, null, "The provided name is Blacklisted"));
		
			}else {
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(new ResponsePage(true, null, "Success"));
			}
		}catch(Exception e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ResponsePage(false, null, "Something went wrong"));
	
		}
	
	}
	
	
}
