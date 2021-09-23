package com.dbs.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CustomerUser {
	
	@Id
	private Long userid;
	
	private String username;
	@OneToOne
	@JoinColumn(name="customerid")
	private Customer customerid;
	
	private String userpassword;
	
	public CustomerUser() {
		
	}

	public CustomerUser(Long userid, String username, Customer customer, String userpassword) {
		super();
		this.userid = userid;
		this.username = username;
		this.customerid = customer;
		this.userpassword = userpassword;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Customer getCustomer() {
		return customerid;
	}

	public void setCustomer(Customer customer) {
		this.customerid = customer;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	
	
}
