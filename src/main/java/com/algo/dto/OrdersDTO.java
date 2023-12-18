package com.algo.dto;

public class OrdersDTO {

	private String symbol;
	private String token;
	private String price;
	private String quantity;
	private String userId
	;
	private String type;
	private String dateTime;
	public String getSymbol() {
		return symbol;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	
	
	
	
}
