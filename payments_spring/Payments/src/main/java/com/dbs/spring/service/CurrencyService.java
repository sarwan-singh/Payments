package com.dbs.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.model.Currency;
import com.dbs.spring.repository.CurrencyRepository;

@Service
public class CurrencyService {

	@Autowired
	private CurrencyRepository repo;
	
	public Currency getCurrencyByCode(String code) {
		Optional<Currency> currency = repo.findById(code);
		if(currency.isPresent()) {
			return currency.get();
		}
		return null;
	}
	
	public double convertIntoInr(double currencyAmount, double transferFee, Currency currency) {
		double convertedAmount = 0;
		convertedAmount += currencyAmount*(currency.getConversionrate());
		convertedAmount += transferFee*(currency.getConversionrate());
		return convertedAmount;
	}
	
}
