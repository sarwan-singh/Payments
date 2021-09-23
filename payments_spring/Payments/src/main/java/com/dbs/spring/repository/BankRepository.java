package com.dbs.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbs.spring.model.Bank;

public interface BankRepository extends CrudRepository<Bank, String>{

}
