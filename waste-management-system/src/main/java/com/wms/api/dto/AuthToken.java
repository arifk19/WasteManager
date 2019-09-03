package com.wms.api.dto;

import java.util.Date;

public class AuthToken {

	private String token;
	private Date tokenExpiryDate;

	private String userRole;

	public AuthToken() {

	}

	public AuthToken(String token, Date tokenExpiryDate, String subject) {
		this.token = token;
		this.tokenExpiryDate = tokenExpiryDate;
		this.userRole = subject;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Date getTokenExpiryDate() {
		return tokenExpiryDate;
	}

	public void setTokenExpiryDate(Date tokenExpiryDate) {
		this.tokenExpiryDate = tokenExpiryDate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}