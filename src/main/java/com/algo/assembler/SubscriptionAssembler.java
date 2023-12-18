package com.algo.assembler;

import com.algo.dto.SubscriptionDTO;
import com.algo.entity.Subscription;

public class SubscriptionAssembler {

	
	private Subscription subscription;  
	private SubscriptionDTO subscriptionDTO ;
	
	public Subscription toSubscription(SubscriptionDTO subscriptionDTO) {
         subscription = new Subscription(); // Initialize the Subscription object
		
		 Subscription.SubscriptionIdAndDate subscriptionIdAndDate=new Subscription.SubscriptionIdAndDate();
		 subscription.setSubscriptionIdAndDate(subscriptionIdAndDate); // Set the SubscriptionId object in Subscription)
		 
		 
		subscription.getSubscriptionIdAndDate().setUserID(subscriptionDTO.getUserID());
		subscription.setSubscription(subscriptionDTO.getSubscription());
		subscription.setAmount(subscriptionDTO.getAmount());
		subscription.setStrategies(subscriptionDTO.getStrategies());
		subscription.getSubscriptionIdAndDate().setDateTime(subscriptionDTO.getDateTime());
		subscription.setId(subscriptionDTO.getId());
			
	return subscription;
	
	}
	
	public SubscriptionDTO fromSubscriptionDTO(Subscription subscription) {
	    subscriptionDTO = new SubscriptionDTO(); // Initialize the SubscriptionDTO object
		subscriptionDTO.setUserID(subscription.getSubscriptionIdAndDate().getUserID());
		subscriptionDTO.setSubscription(subscription.getSubscription());
		subscriptionDTO.setAmount(subscription.getAmount());
		subscriptionDTO.setStrategies(subscription.getStrategies());
		subscriptionDTO.setDateTime(subscription.getSubscriptionIdAndDate().getDateTime());
		subscriptionDTO.setId(subscription.getId());	
		
		return subscriptionDTO;		
	}
	
	
}
