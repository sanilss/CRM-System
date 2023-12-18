package com.algo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "trades")
public class Trades {
	@EmbeddedId
	private TradesId tradesId;

	@Column(name = "Type")
	private String type;

	@Column(name = "Qty")
	private String quantity;

	@Column(name = "Price")
	private String price;

	@Column(name = "Strategy")
	private String stratergy;
	
	@Column(name = "IdxPrice")
	private String indexPrice;
	
	@Column(name = "Position")
	private String position;

	// Inner class for composite key
	@Embeddable
	public static class TradesId implements Serializable {
		@Column(name = "Name")
		private String name;
		
		@Column(name = "Token")
		private String token;

		@Column(name = "DateTime")
		private String dateTime;
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}


		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		
		public String getDateTime() {
			return dateTime;
		}

		public void setDateTime(String dateTime) {
			this.dateTime = dateTime;
		}
		
		
	}
	
	public void setTradesId(TradesId tradesId ) {
		
		this.tradesId=tradesId;
	}
	
	
	public TradesId getTradesId() {
		return tradesId;
	}
	
	
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStratergy() {
		return stratergy;
	}

	public void setStratergy(String stratergy) {
		this.stratergy = stratergy;
	}
	
	public String getIndexPrice() {
		return indexPrice;
	}

	public void setIndexPrice(String indexPrice) {
		this.indexPrice = indexPrice;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	
}