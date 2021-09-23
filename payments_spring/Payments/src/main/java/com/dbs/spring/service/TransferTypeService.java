package com.dbs.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.model.TransferTypes;
import com.dbs.spring.repository.TransferTypesRepository;

@Service
public class TransferTypeService {

	@Autowired
	private TransferTypesRepository repo;
	
	public TransferTypes getTransaTransferTypesByCode(char code) {
		Optional<TransferTypes> transferTypes = repo.findById(code);
		if(transferTypes.isPresent()) {
			return transferTypes.get();
		}
		return null;
	}
	
}
