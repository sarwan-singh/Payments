package com.dbs.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	private Long employeeid;
	
	private String employeename;
	
	private String employeepassword;
	
	@OneToOne
	@JoinColumn(name="customerid")
	private Customer customerid;
	
	public Employee() {
		
	}

	public Employee(Long employeeid, String employeename, String employeepassword, Customer customerid) {
		super();
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.employeepassword = employeepassword;
		this.customerid = customerid;
	}

	public Long getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Long employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getEmployeepassword() {
		return employeepassword;
	}

	public void setEmployeepassword(String employeepassword) {
		this.employeepassword = employeepassword;
	}

	public Customer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Customer customerid) {
		this.customerid = customerid;
	}
	 
	
}
