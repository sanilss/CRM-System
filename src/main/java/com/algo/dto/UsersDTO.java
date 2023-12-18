package com.algo.dto;

import com.algo.domainobjects.DomainObjectDTO;

public class UsersDTO extends DomainObjectDTO{
	private String userId;

	private String name;

	private String password;

	private String mobile;

	private String email;

	private String dob;
	
	private String welcome;
	
	private String dateAndTime;

	private String referralAccountStatus;

	private String referralAccountById;

	private String referralAccountBy;

	private String subscriptionStatus;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getWelcome() {
		return welcome;
	}

	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}

	public String getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getReferralAccountStatus() {
		return referralAccountStatus;
	}

	public void setReferralAccountStatus(String referralAccountStatus) {
		this.referralAccountStatus = referralAccountStatus;
	}

	public String getReferralAccountById() {
		return referralAccountById;
	}

	public void setReferralAccountById(String referralAccountById) {
		this.referralAccountById = referralAccountById;
	}

	public String getReferralAccountBy() {
		return referralAccountBy;
	}

	public void setReferralAccountBy(String referralAccountBy) {
		this.referralAccountBy = referralAccountBy;
	}

	public String getSubscriptionStatus() {
		return subscriptionStatus;
	}

	public void setSubscriptionStatus(String subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}

	
}
