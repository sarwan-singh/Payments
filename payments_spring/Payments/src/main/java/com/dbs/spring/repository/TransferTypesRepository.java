package com.dbs.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbs.spring.model.Bank;
import com.dbs.spring.model.TransferTypes;

@Repository
public interface TransferTypesRepository extends CrudRepository<TransferTypes, Character>{

}
