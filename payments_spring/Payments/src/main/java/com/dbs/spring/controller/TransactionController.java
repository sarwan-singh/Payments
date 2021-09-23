package com.dbs.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.model.Customer;
import com.dbs.spring.model.Transaction;
import com.dbs.spring.model.TransactionRequest;
import com.dbs.spring.repository.BankRepository;
import com.dbs.spring.repository.TransactionRepository;
import com.dbs.spring.service.CustomerService;
import com.dbs.spring.service.TransactionService;

@RestController
@RequestMapping("/transaction")
@CrossOrigin
public class TransactionController {

	@Autowired
	private TransactionService service;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("")
	public ResponseEntity<Object> getAll() {
		try {
			List<Transaction> transactions= service.getAllTransaction();
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponsePage(true, transactions, "Success"));
					
		}catch(Exception e) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponsePage(false, null, "Something went wrong"));
		}
	}
	
	@GetMapping("/user")
	public ResponseEntity<Object> getByCustomerId(){
		try {
			List<Transaction> transactions;
			try {
				transactions = service.getTransactionsByCustomerId();
			}catch(Exception e) {
				return ResponseEntity
						.status(HttpStatus.UNAUTHORIZED)
						.body(new ResponsePage(false, null, "Token is expired or invalid"));
					
			}
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponsePage(true, transactions, "Success"));
					
		}catch(Exception e) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponsePage(false, null, "Something went wrong"));
		}
	}
	
	@PostMapping("/user")
	public ResponseEntity<ResponsePage> addTransaction(@RequestBody TransactionRequest transactionRequest) {
		try {
			ResponseEntity<ResponsePage> populatedTransaction = service.populateTransaction(transactionRequest);
			if(populatedTransaction.getBody().getStatus()==false) {
				return populatedTransaction;
			}
			Transaction transaction = (Transaction) populatedTransaction.getBody().getData();
			boolean inserted = service.addTransaction(transaction);
			if(inserted) {
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(new ResponsePage(true, transaction, "Success"));
			}else {
				customerService.updateCustomer(transaction.getCustomerid());
//				System.out.println(transaction);
				return ResponseEntity
						.status(HttpStatus.BAD_REQUEST)
						.body(new ResponsePage(false, inserted, "Transaction already exists"));
			}
			
		}catch(Exception e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ResponsePage(false, null, "Something went wrong"));
		}
	}
	
	@GetMapping("/withId/{id}")
	public ResponseEntity<Object> getByTransactionId(@PathVariable long id) {
		Transaction transaction = service.getTransactionWithId(id);
		try {
		if(transaction==null) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ResponsePage(false, transaction, "Transaction doesn't exist with the provided id"));
		}else {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponsePage(true, transaction, "Success"));
		
		}
		}catch(Exception e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ResponsePage(false, null, "Something went wrong"));	
		}
	}
}
