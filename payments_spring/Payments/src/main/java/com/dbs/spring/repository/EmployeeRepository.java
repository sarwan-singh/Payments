package com.dbs.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbs.spring.model.Bank;
import com.dbs.spring.model.CustomerUser;
import com.dbs.spring.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	public Optional<Employee> findByEmployeename(String username);
	
}
