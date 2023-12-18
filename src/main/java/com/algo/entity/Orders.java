package com.algo.entity;

import java.io.Serializable;

 
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Orders {
	@EmbeddedId
	private OrderIdAndDate orderIdAndDate;

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

	@Embeddable
	public static class OrderIdAndDate implements Serializable {
		@Column(name = "DateTime")
		private String dateTime;

		@Column(name = "UserID")
		private String userId;

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getDateTime() {
			return dateTime;
		}

		public void setDateTime(String dateTime) {
			this.dateTime = dateTime;
		}

	}

	// Add this setter method
	public void setOrderIdAndDate(OrderIdAndDate orderId) {
		this.orderIdAndDate = orderIdAndDate;
	}

	// Add this getter method
	public OrderIdAndDate getOrderIdAndDate() {
		return orderIdAndDate;
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

}
