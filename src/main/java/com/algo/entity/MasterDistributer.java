package com.algo.entity;

import org.hibernate.annotations.GenericGenerator;

import com.algo.domainobjects.DomainObject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
@Table(name = "master_distributer")
public class MasterDistributer extends DomainObject {

	@Id
	@GeneratedValue(generator = "Master_Distributer_gen", strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "Master_Distributer_gen", strategy = "com.algo.config.DistributerIdGenerator", parameters = @org.hibernate.annotations.Parameter(name = "type", value = "String"))
	@Column(name = "ID")
	private String id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "MOBILE")
	private String mobile;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "DOB")
	private String dob;

	@Column(name = "REFCODE")
	private String refCode;

	@Column(name = "EMP_STATUS")
	private String empStatus;

	@Column(name = "COMISSION_AMOUNT")
	private String comissionAmount;

	@Column(name = "COMISSION_PERCENT")
	private String comissionPercent;

	@Column(name = "REFERRAL_ACCOUNT_STATUS")
	private String referralAccountStatus;

	@Column(name = "ROLE")
	private String role;

	@Column(name = "SALREF")
	private String salref;

	@Column(name = "ISACTIVE")
	private boolean isActive;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_DATE")
	private String createdDate;

	@Column(name = "MODIFIED_BY")
	private String modifiedBy;

	@Column(name = "MODIFIED_DATE")
	private String modifiedDate;

	@Column(name = "VERSION")
	private String version;


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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}


}
