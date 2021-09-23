package com.dbs.spring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionid;
	
	@OneToOne
	@JoinColumn(name="customerid")
	private Customer customerid;

	@OneToOne
	@JoinColumn(name="currencycode")
	private Currency currencycode;
	
	@OneToOne
	@JoinColumn(name="senderBIC")
	private Bank senderBIC;
	
	@OneToOne
	@JoinColumn(name="receiverBIC")
	private Bank receiverBIC;
	
	private String receiveraccountholdernumber;
	
	private String receiveraccountholdername;
	
	@OneToOne
	@JoinColumn(name="transfertypecode")
	private TransferTypes transfertypecode;

	@OneToOne
	@JoinColumn(name="messagecode")
	private Message messagecode;
	
	private double currencyamount;
	
	private double transferfees;
	
	private double inramount;
	
	private Date transferdate;

	public Transaction() {
		
	}

	public Transaction(Long transactionid, Customer customerid, Currency currencycode, Bank senderBIC, Bank receiverBIC,
			String receiveraccountholdernumber, String receiveraccountholdername, TransferTypes transfertypecode,
			Message messagecode, double currencyamount, double trasferfees, double inramount, Date transferdate) {
		super();
		this.transactionid = transactionid;
		this.customerid = customerid;
		this.currencycode = currencycode;
		this.senderBIC = senderBIC;
		this.receiverBIC = receiverBIC;
		this.receiveraccountholdernumber = receiveraccountholdernumber;
		this.receiveraccountholdername = receiveraccountholdername;
		this.transfertypecode = transfertypecode;
		this.messagecode = messagecode;
		this.currencyamount = currencyamount;
		this.transferfees = trasferfees;
		this.inramount = inramount;
		this.transferdate = transferdate;
	}

	public Long getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(Long transactionid) {
		this.transactionid = transactionid;
	}

	public Customer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Customer customerid) {
		this.customerid = customerid;
	}

	public Currency getCurrencycode() {
		return currencycode;
	}

	public void setCurrencycode(Currency currencycode) {
		this.currencycode = currencycode;
	}

	public Bank getSenderBIC() {
		return senderBIC;
	}

	public void setSenderBIC(Bank senderBIC) {
		this.senderBIC = senderBIC;
	}

	public Bank getReceiverBIC() {
		return receiverBIC;
	}

	public void setReceiverBIC(Bank receiverBIC) {
		this.receiverBIC = receiverBIC;
	}

	public String getReceiveraccountholdernumber() {
		return receiveraccountholdernumber;
	}

	public void setReceiveraccountholdernumber(String receiveraccountholdernumber) {
		this.receiveraccountholdernumber = receiveraccountholdernumber;
	}

	public String getReceiveraccountholdername() {
		return receiveraccountholdername;
	}

	public void setReceiveraccountholdername(String receiveraccountholdername) {
		this.receiveraccountholdername = receiveraccountholdername;
	}

	public TransferTypes getTransfertypecode() {
		return transfertypecode;
	}

	public void setTransfertypecode(TransferTypes transfertypecode) {
		this.transfertypecode = transfertypecode;
	}

	public Message getMessagecode() {
		return messagecode;
	}

	public void setMessagecode(Message messagecode) {
		this.messagecode = messagecode;
	}

	public double getCurrencyamount() {
		return currencyamount;
	}

	public void setCurrencyamount(double currencyamount) {
		this.currencyamount = currencyamount;
	}

	public double getTrasferfees() {
		return transferfees;
	}

	public void setTrasferfees(double trasferfees) {
		this.transferfees = trasferfees;
	}

	public double getInramount() {
		return inramount;
	}

	public void setInramount(double inramount) {
		this.inramount = inramount;
	}

	public Date getTransferdate() {
		return transferdate;
	}

	public void setTransferdate(Date transferdate) {
		this.transferdate = transferdate;
	}

	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", customerid=" + customerid + ", currencycode="
				+ currencycode + ", senderBIC=" + senderBIC + ", receiverBIC=" + receiverBIC
				+ ", receiveraccountholdernumber=" + receiveraccountholdernumber + ", receiveraccountholdername="
				+ receiveraccountholdername + ", transfertypecode=" + transfertypecode + ", messagecode=" + messagecode
				+ ", currencyamount=" + currencyamount + ", transferfees=" + transferfees + ", inramount=" + inramount
				+ ", transferdate=" + transferdate + "]";
	}
	
	
	
}
