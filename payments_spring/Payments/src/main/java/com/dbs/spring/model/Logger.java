package com.dbs.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Logger {

	@Id
	private Long loggerid;
	
	@OneToOne
	@JoinColumn(name="customerid")
	private Customer customerid;
	
	@OneToOne
	@JoinColumn(name="userid")
	private CustomerUser userid;
	
	@OneToOne
	@JoinColumn(name="employeeid")
	private Employee employeeid;
	
	private String screename;
	
	private String action;
	
	private String ipaddress;
	
	public Logger() {
		
	}

	public Logger(Long loggerid, Customer customerid, CustomerUser userid, Employee employeeid, String screename,
			String action, String ipaddress) {
		super();
		this.loggerid = loggerid;
		this.customerid = customerid;
		this.userid = userid;
		this.employeeid = employeeid;
		this.screename = screename;
		this.action = action;
		this.ipaddress = ipaddress;
	}



	public Long getLoggerid() {
		return loggerid;
	}

	public void setLoggerid(Long loggerid) {
		this.loggerid = loggerid;
	}

	public Customer getCustomer() {
		return customerid;
	}

	public void setCustomer(Customer customer) {
		this.customerid = customer;
	}

	public CustomerUser getCustomeruser() {
		return userid;
	}

	public void setCustomeruser(CustomerUser customeruser) {
		this.userid = customeruser;
	}

	public Employee getEmployee() {
		return employeeid;
	}

	public void setEmployee(Employee employee) {
		this.employeeid = employee;
	}

	public String getScreename() {
		return screename;
	}

	public void setScreename(String screename) {
		this.screename = screename;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	
	
	
}
