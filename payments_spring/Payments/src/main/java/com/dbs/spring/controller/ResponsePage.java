package com.dbs.spring.controller;

public class ResponsePage {

	private boolean status;
	
	private Object data;
	
	private String description;
	
	public ResponsePage() {
		
	}

	public ResponsePage(boolean status, Object data, String description) {
		super();
		this.status = status;
		this.data = data;
		this.description = description;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
