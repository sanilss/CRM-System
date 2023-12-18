package com.algo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "commission")
public class Commission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private String id;

	@Column(name = "distributerCommission")
	public String distributerCommission;
	
	@Column(name = "salesAdminCommission")
	public String salesAdminCommission;
	
	@Column(name = "masterAdminCommission")
	public String masterAdminCommission;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDistributerCommission() {
		return distributerCommission;
	}

	public void setDistributerCommission(String distributerCommission) {
		this.distributerCommission = distributerCommission;
	}

	public String getSalesAdminCommission() {
		return salesAdminCommission;
	}

	public void setSalesAdminCommission(String salesAdminCommission) {
		this.salesAdminCommission = salesAdminCommission;
	}

	public String getMasterAdminCommission() {
		return masterAdminCommission;
	}

	public void setMasterAdminCommission(String masterAdminCommission) {
		this.masterAdminCommission = masterAdminCommission;
	}
	
	
}
