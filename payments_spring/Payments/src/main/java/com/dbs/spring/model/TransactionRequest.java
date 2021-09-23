package com.dbs.spring.model;

public class TransactionRequest {

	private String recieverName;
	private String recieverAccountNumber;
	private double amount;
	private String currency;
	private String message;
	private String bankCode;
	
	public TransactionRequest(){
		
	}

	public TransactionRequest(String recieverName, String recieverAccountNumber, double amount, String currency,
			String message, String bankCode) {
		super();
		this.recieverName = recieverName;
		this.recieverAccountNumber = recieverAccountNumber;
		this.amount = amount;
		this.currency = currency;
		this.message = message;
		this.bankCode = bankCode;
	}

	public String getRecieverName() {
		return recieverName;
	}

	public void setRecieverName(String recieverName) {
		this.recieverName = recieverName;
	}

	public String getRecieverAccountNumber() {
		return recieverAccountNumber;
	}

	public void setRecieverAccountNumber(String recieverAccountNumber) {
		this.recieverAccountNumber = recieverAccountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	
	
}
