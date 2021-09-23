package com.dbs.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbs.spring.model.Bank;
import com.dbs.spring.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long>{

	public List<Transaction> findByCustomeridCustomerid(String id);
}
