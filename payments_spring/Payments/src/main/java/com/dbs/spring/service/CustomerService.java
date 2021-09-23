package com.dbs.spring.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.model.Customer;
import com.dbs.spring.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	public boolean updateCustomer(Customer customer) {
		repo.save(customer);
		return true;
	}

	public Customer getCustomerById(String id) {
		
		Optional<Customer> opt = repo.findById(id);
		System.out.println(opt.isPresent());
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	public List<Customer> getAllCustomers(){
		List<Customer> customers = new ArrayList<>();
		repo.findAll().forEach(i->customers.add(i));
		return customers;
	}
	
	public boolean checkUser(String id, char type) {
		Optional<Customer> opt = repo.findById(id);
		if(opt.get().getCustomertype()==type) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean checkSdnList(String name) throws IOException {
		
		File sdnFile = new File("C:\\Users\\Administrator\\Desktop\\springWorkSpace\\Payments//sdnlist.txt");
  
		BufferedReader br = new BufferedReader(new FileReader(sdnFile));
		String st;
		while ((st = br.readLine()) != null) {
			String[] words = st.split(" ");
			for(String i: words) {
				if(i.trim().equalsIgnoreCase(name)) {
					return true;
				}
			}
		}
		return false;
		
	}
}
