package com.dbs.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Currency {

	@Id
	private String currencycode;
	
	private String currencyname;
	
	private double conversionrate;
	
	public Currency() {
		
	}

	public Currency(String currencycode, String currencyname, double conversionrate) {
		this.currencycode = currencycode;
		this.currencyname = currencyname;
		this.conversionrate = conversionrate;
	}

	public String getCurrencycode() {
		return currencycode;
	}

	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}

	public String getCurrencyname() {
		return currencyname;
	}

	public void setCurrencyname(String currencyname) {
		this.currencyname = currencyname;
	}

	public double getConversionrate() {
		return conversionrate;
	}

	public void setConversionrate(double conversionrate) {
		this.conversionrate = conversionrate;
	}

	@Override
	public String toString() {
		return "Currency [currencycode=" + currencycode + ", currencyname=" + currencyname + ", conversionrate="
				+ conversionrate + "]";
	}
	
	
}
