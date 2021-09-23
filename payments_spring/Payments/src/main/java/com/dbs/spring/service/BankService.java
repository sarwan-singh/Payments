package com.dbs.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.model.Bank;
import com.dbs.spring.repository.BankRepository;

@Service
public class BankService {

	@Autowired
	private BankRepository repo;
	
	public List<Bank> getAllBanks(){
		List<Bank> banks = new ArrayList<>();
		repo.findAll().forEach(i->banks.add(i));
		return banks;
	}
	
	public Bank getBankWithId(String id) {
		Optional<Bank> opt = repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
}
