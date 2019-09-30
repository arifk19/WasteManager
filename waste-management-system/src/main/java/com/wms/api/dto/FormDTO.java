/* 
 * ===========================================================================
 * File Name FormDTO.java
 * 
 * Created on Sep 13, 2019
 *
 * This code contains copyright information which is the proprietary property
 * of ITkhan India Pvt. Ltd. No part of this code may be reproduced, stored or transmitted
 * in any form without the prior written permission of ITkhan.
 *
 * Copyright (C) ITkhan. 2019
 * All rights reserved.
 *
 * Modification history:
 * $Log: FormDTO.java,v $
 * ===========================================================================
 */
package com.wms.api.dto;

public class FormDTO {

	private String firstName;
	private String lastName;
	private String companyEmail;
	private boolean status;
	private String phoneNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
