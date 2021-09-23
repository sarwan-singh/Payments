package com.dbs.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.model.Customer;
import com.dbs.spring.model.CustomerUser;
import com.dbs.spring.repository.CustomerUserRepository;

@Service
public class CustomerUserService {

	@Autowired
	private CustomerUserRepository customerUserRepository;
	
	public Customer getCustomerByUserName(String name) {
		try {
			Optional<CustomerUser> opt = customerUserRepository.findByUsername(name);
			if(opt.isPresent()) {
				return opt.get().getCustomer();
			}else {
				return null;
			}
		}catch(Exception e) {
			return null;
		}
	}
	
}
