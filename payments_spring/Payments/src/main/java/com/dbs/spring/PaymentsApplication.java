package com.dbs.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dbs.spring.model.Bank;
import com.dbs.spring.model.Currency;
import com.dbs.spring.repository.BankRepository;
import com.dbs.spring.repository.CurrencyRepository;
import com.dbs.spring.repository.CustomerRepository;
import com.dbs.spring.repository.TransactionRepository;
import com.dbs.spring.service.TransactionService;

@SpringBootApplication
public class PaymentsApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(PaymentsApplication.class, args);
	}

}
