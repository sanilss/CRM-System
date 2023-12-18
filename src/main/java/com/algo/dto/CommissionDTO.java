package com.algo.dto;

public class CommissionDTO {
public String id;

public String distributerCommission;

public String salesAdminCommission;

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
