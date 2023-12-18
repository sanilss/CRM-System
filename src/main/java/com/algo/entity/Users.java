package com.algo.entity;

import com.algo.domainobjects.DomainObject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sign_up_temp")
public class Users extends DomainObject {

	@Id
	@Column(name = "UserID")
	private String userId;

	@Column(name = "Name")
	private String name;

	@Column(name = "Password")
	private String password;

	@Column(name = "Number")
	private String mobile;

	@Column(name = "EmailID")
	private String email;
	
	@Column(name = "Welcome")
	private String welcome;
	
	@Column(name = "DateTime")
	private String dateAndTime;

	@Column(name = "DOB")
	private String dob;

	@Column(name = "ReferralAccountStatus")
	private String referralAccountStatus;

	@Column(name = "ReferralAccountById")
	private String referralAccountById;

	@Column(name = "ReferralAccountBy")
	private String referralAccountBy;

	@Column(name = "SubscriptionStatus")
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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
