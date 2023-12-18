package com.algo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "Summary")
public class Summary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "ID")
	private String id;
	
	@Column(name = "Symbol")
	private String symbol;

	@Column(name = "Token")
	private String token;

	@Column(name = "Price")
	private String price;

	@Column(name = "Quantity")
	private String quantity;

	@Column(name = "Type")
	private String type;

	@Column(name = "DateTime")
	private String dateTime;
	
	@Column(name = "CommisionIdDIS")
	private String commissionIdDIS;
	
	@Column(name = "CommisionOfDIS")
	private String commissionOfDIS;
	
	@Column(name = "CommisionIdMD")
	private String commissionIdMD;
	
	@Column(name = "CommisionOfMD")
	private String commissionOfMD;
	
	@Column(name = "CommisionIdSA")
	private String commissionIDSA;
	
	@Column(name = "CommisionOfSA")
	private String commissionOfSA;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getCommissionIdDIS() {
		return commissionIdDIS;
	}

	public void setCommissionIdDIS(String commissionIdDIS) {
		this.commissionIdDIS = commissionIdDIS;
	}

	public String getCommissionOfDIS() {
		return commissionOfDIS;
	}

	public void setCommissionOfDIS(String commissionOfDIS) {
		this.commissionOfDIS = commissionOfDIS;
	}

	public String getCommissionIdMD() {
		return commissionIdMD;
	}

	public void setCommissionIdMD(String commissionIdMD) {
		this.commissionIdMD = commissionIdMD;
	}

	public String getCommissionOfMD() {
		return commissionOfMD;
	}

	public void setCommissionOfMD(String commissionOfMD) {
		this.commissionOfMD = commissionOfMD;
	}

	public String getCommissionIDSA() {
		return commissionIDSA;
	}

	public void setCommissionIDSA(String commissionIDSA) {
		this.commissionIDSA = commissionIDSA;
	}

	public String getCommissionOfSA() {
		return commissionOfSA;
	}

	public void setCommissionOfSA(String commissionOfSA) {
		this.commissionOfSA = commissionOfSA;
	}
	


}
