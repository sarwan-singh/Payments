package com.dbs.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbs.spring.model.Bank;
import com.dbs.spring.model.Currency;

public interface CurrencyRepository extends CrudRepository<Currency, String>{
	
}
