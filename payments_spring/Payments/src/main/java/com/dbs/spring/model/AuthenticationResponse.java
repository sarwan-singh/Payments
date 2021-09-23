package com.dbs.spring.model;

public class AuthenticationResponse {

	private final boolean status;
	private final String jwt;

	
	public AuthenticationResponse(boolean status, String jwt) {
		this.jwt = jwt;
		this.status = status;
	}

	public boolean getStatus() {
		return status;
	}

	public String getJwt() {
		return jwt;
	}
	
}
