package com.wms.api.dto;

import java.util.Date;

public class AuthToken {

	private String token;
	private Date tokenExpiryDate;

	public Date getTokenExpiryDate() {
		return tokenExpiryDate;
	}

	public void setTokenExpiryDate(Date tokenExpiryDate) {
		this.tokenExpiryDate = tokenExpiryDate;
	}

	public AuthToken() {

	}

	
	public AuthToken(String token, Date tokenExpiryDate) {
		this.token = token;
		this.tokenExpiryDate = tokenExpiryDate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}