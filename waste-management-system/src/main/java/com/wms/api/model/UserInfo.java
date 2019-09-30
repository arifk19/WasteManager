package com.wms.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "USER_INFO")
public class UserInfo {

	@Id
	@Column(name = "VISITOR_ID")
	/*
	 * @GeneratedValue(generator = "foreign_gen")
	 * 
	 * @GenericGenerator(name = "foreign_gen", strategy = "foreign", parameters = {
	 * 
	 * @Parameter(name = "property", value = "authInfo") })
	 */
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long vistorId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "COMPANY_EMAIL")
	private String companyEmail;

	@Column(name = "COMPANY_NAME")
	private String companyName;

	@Column(name = "INDUSTRY_DESC")
	private String industryDescription;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "STATUS")
	private boolean status;

	@Column(name = "SOURCE_SYSTEM_DESC")
	private String sourceSystemDescription;

	//@OneToOne
		
	private AuthInfo authInfo;

	public long getVistorId() {
		return vistorId;
	}

	public void setVistorId(long vistorId) {
		this.vistorId = vistorId;
	}

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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getIndustryDescription() {
		return industryDescription;
	}

	public void setIndustryDescription(String industryDescription) {
		this.industryDescription = industryDescription;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getSourceSystemDescription() {
		return sourceSystemDescription;
	}

	public void setSourceSystemDescription(String sourceSystemDescription) {
		this.sourceSystemDescription = sourceSystemDescription;
	}

	public AuthInfo getAuthInfo() {
		return authInfo;
	}

	public void setAuthInfo(AuthInfo authInfo) {
		this.authInfo = authInfo;
	}

}