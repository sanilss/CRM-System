package com.algo.dto;

import com.algo.domainobjects.DomainObjectDTO;

public class DistributerDTO extends DomainObjectDTO {

	private String id;

	private String name;

	private String username;

	private String password;

	private String mobile;

	private String email;

	private String dob;

	private String refCode;

	private String empStatus;

	private String comissionAmount;

	private String comissionPercent;

	private String referralAccountStatus;

	private String role;

	private String mdref;

	private String salref;
	
	private boolean isActive;



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getRefCode() {
		return refCode;
	}

	public void setRefCode(String refCode) {
		this.refCode = refCode;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	public String getComissionAmount() {
		return comissionAmount;
	}

	public void setComissionAmount(String comissionAmount) {
		this.comissionAmount = comissionAmount;
	}

	public String getComissionPercent() {
		return comissionPercent;
	}

	public void setComissionPercent(String comissionPercent) {
		this.comissionPercent = comissionPercent;
	}

	public String getReferralAccountStatus() {
		return referralAccountStatus;
	}

	public void setReferralAccountStatus(String referralAccountStatus) {
		this.referralAccountStatus = referralAccountStatus;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMdref() {
		return mdref;
	}

	public void setMdref(String mdref) {
		this.mdref = mdref;
	}
	
	

	public String getSalref() {
		return salref;
	}

	public void setSalref(String salref) {
		this.salref = salref;
	}

	public boolean getisActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



}
