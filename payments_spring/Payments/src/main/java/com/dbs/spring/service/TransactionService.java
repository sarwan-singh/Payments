package com.dbs.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dbs.spring.controller.ResponsePage;
import com.dbs.spring.model.Bank;
import com.dbs.spring.model.Currency;
import com.dbs.spring.model.Customer;
import com.dbs.spring.model.Message;
import com.dbs.spring.model.Transaction;
import com.dbs.spring.model.TransactionRequest;
import com.dbs.spring.repository.BankRepository;
import com.dbs.spring.repository.CurrencyRepository;
import com.dbs.spring.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository repo;
	
	@Autowired
	private CustomerUserService customerUserService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private CurrencyService currencyService;
	
	@Autowired
	private TransferTypeService transferTypeService;
	
	@Autowired
	private BankService bankService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private ResponseEntityService responseEntityService;
	
	public List<Transaction> getTransactionsByCustomerId(){
		Customer customer = customerUserService.getCustomerByUserName(jwtService.getUserNameFromSecurity());
		System.out.println(customer.getAccountholdername());
		List<Transaction> transactions = new ArrayList<>();
		repo.findByCustomeridCustomerid(customer.getCustomerid()).forEach(i->transactions.add(i));
		return transactions;
	}
	
	public ResponseEntity<ResponsePage> populateTransaction(TransactionRequest transactionRequest) {
		Transaction transaction = new Transaction();
		try {
			if(customerService.checkSdnList(transactionRequest.getRecieverName())) {
				return responseEntityService.createResponseEntity(HttpStatus.BAD_REQUEST,false, null, "The reciever account is Blacklisted");
			}
			transaction.setReceiveraccountholdername(transactionRequest.getRecieverName());
			if(transactionRequest.getRecieverAccountNumber().trim().length()<12||transactionRequest.getRecieverAccountNumber().trim().length()>12) {
				return responseEntityService.createResponseEntity(HttpStatus.BAD_REQUEST,false, null, "The reciever account number should consist 12 digits");
			}
			transaction.setReceiveraccountholdernumber(transactionRequest.getRecieverAccountNumber());
			try{
				Customer customer = customerUserService.getCustomerByUserName(jwtService.getUserNameFromSecurity());
				transaction.setCustomerid(customer);
			}catch(Exception e){
				return responseEntityService.createResponseEntity(HttpStatus.BAD_REQUEST, false, null, "Unauthorized access");
			}
			
			Message message = messageService.getMessageByCode(transactionRequest.getMessage());
			if(message==null) {
				return responseEntityService.createResponseEntity(HttpStatus.BAD_REQUEST, false, null, "Invalid message code");
			}
			transaction.setMessagecode(message);
			
			Currency currency = currencyService.getCurrencyByCode(transactionRequest.getCurrency());
			if(currency==null) {
				return responseEntityService.createResponseEntity(HttpStatus.BAD_REQUEST, false, null, "Invalid currency code");
			}
			transaction.setCurrencycode(currency);
			if(transaction.getCustomerid().getCustomertype()=='I') {
				transaction.setTransfertypecode(transferTypeService.getTransaTransferTypesByCode('C'));
			}else {
				transaction.setTransfertypecode(transferTypeService.getTransaTransferTypesByCode('O'));
			}
			transaction.setSenderBIC(bankService.getBankWithId("ABKBBANK"));
			Bank recieverBank = bankService.getBankWithId(transactionRequest.getBankCode());
			if(recieverBank==null) {
				return responseEntityService.createResponseEntity(HttpStatus.BAD_REQUEST, false, null, "Invalid Bank code");
			}
			transaction.setReceiverBIC(recieverBank);
			
			if(transactionRequest.getAmount()<=0) {
				return responseEntityService.createResponseEntity(HttpStatus.BAD_REQUEST, false, null, "Amount should be greater than 0");	
			}
			System.out.println(transactionRequest.getAmount());
			System.out.println(transactionRequest.getAmount()*0.025);
			
			transaction.setCurrencyamount(transactionRequest.getAmount());
			transaction.setTrasferfees(transactionRequest.getAmount()*(0.025));
			transaction.setInramount(currencyService.convertIntoInr(transaction.getCurrencyamount(), transaction.getTrasferfees(), transaction.getCurrencycode()));
			System.out.println(currencyService.convertIntoInr(transaction.getCurrencyamount(), transaction.getTrasferfees(), transaction.getCurrencycode()));
			transaction.setTransferdate(new Date());
			
			//Customer data update
			Customer customer = transaction.getCustomerid();
			if(customer.getClearbalance()<transaction.getInramount()&&customer.isOverdraftflag()==false) {
				return responseEntityService.createResponseEntity(HttpStatus.BAD_REQUEST, false, null, "Not enough clear balance");	
			}
			customer.setClearbalance(customer.getClearbalance()-transaction.getInramount());
			customerService.updateCustomer(customer);
		}catch(Exception e) {
			return responseEntityService.createResponseEntity(HttpStatus.BAD_REQUEST, false, null, "Something went wrong");
		}
		return responseEntityService.createResponseEntity(HttpStatus.BAD_REQUEST, true, transaction, "Success");
	}
	
	public List<Transaction> getAllTransaction(){
		
		List<Transaction> transactions = new ArrayList<>();
		repo.findAll().forEach(i->transactions.add(i));;
		return transactions;
	}
	
	public Transaction getTransactionWithId(long id) {
		Optional<Transaction> transaction = repo.findById(id);

		if(transaction.isPresent()) {
			return transaction.get();
		}else {
			return null;
		}
	}
	
	public boolean addTransaction(Transaction transaction) {
		try {
			repo.save(transaction);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	
	public boolean validateTransaction(Transaction transaction) {
		if(transaction.getCustomerid().isOverdraftflag()) {
			return true;
		}else {
			if(transaction.getInramount()<=transaction.getCustomerid().getClearbalance()) {
				return true;
			}else {
				return false;
			}
		}
	}
}
