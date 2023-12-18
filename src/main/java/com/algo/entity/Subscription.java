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
@Table(name = "subcription")
public class Subscription {

	@EmbeddedId
	private SubscriptionIdAndDate subscriptionIdAndDate;

	@Column(name = "ID")
	private String id;

	@Column(name = "Subcription")
	private String subscription;

	@Column(name = "Amount")
	private String amount;

	@Column(name = "Strategies")
	private String strategies;

	@Embeddable
	public static class SubscriptionIdAndDate implements Serializable {
		@Column(name = "DateTime")
		private String dateTime;

		@Column(name = "UserID")
		private String userID;

		public String getUserID() {
			return userID;
		}

		public void setUserID(String userID) {
			this.userID = userID;
		}

		public String getDateTime() {
			return dateTime;
		}

		public void setDateTime(String dateTime) {
			this.dateTime = dateTime;
		}
	
	}
	
	 // Add this setter method
    public void setSubscriptionIdAndDate(SubscriptionIdAndDate subscriptionId) {
        this.subscriptionIdAndDate = subscriptionIdAndDate;
    }

    // Add this getter method
    public SubscriptionIdAndDate getSubscriptionIdAndDate() {
        return subscriptionIdAndDate;
    }
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubscription() {
		return subscription;
	}

	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStrategies() {
		return strategies;
	}

	public void setStrategies(String strategies) {
		this.strategies = strategies;
	}

}
