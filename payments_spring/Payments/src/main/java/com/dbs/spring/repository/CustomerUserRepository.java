package com.dbs.spring.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbs.spring.model.Bank;
import com.dbs.spring.model.CustomerUser;

@Repository
public interface CustomerUserRepository extends CrudRepository<CustomerUser, Long>{

	public Optional<CustomerUser> findByUsername(String username);
	
}
