package com.dbs.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TransferTypes {

	@Id
	private Character transfertypecode;
	
	private String transfertypedescription;
	
	public TransferTypes() {
		
	}

	public TransferTypes(Character transfertypecode, String transfertypedescription) {
		super();
		this.transfertypecode = transfertypecode;
		this.transfertypedescription = transfertypedescription;
	}

	public Character getTransfertypecode() {
		return transfertypecode;
	}

	public void setTransfertypecode(Character transfertypecode) {
		this.transfertypecode = transfertypecode;
	}

	public String getTransfertypedescription() {
		return transfertypedescription;
	}

	public void setTransfertypedescription(String transfertypedescription) {
		this.transfertypedescription = transfertypedescription;
	}

	@Override
	public String toString() {
		return "TransferTypes [transfertypecode=" + transfertypecode + ", transfertypedescription="
				+ transfertypedescription + "]";
	}
	
	
}
