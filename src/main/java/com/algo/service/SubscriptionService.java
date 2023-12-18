package com.algo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.algo.assembler.SubscriptionAssembler;
import com.algo.dto.SubscriptionDTO;
import com.algo.entity.Subscription;
import com.algo.repository.SubscriptionRepository;



@Service

public class SubscriptionService {
	SubscriptionAssembler subscriptionAssembler = new SubscriptionAssembler();
	private final SubscriptionRepository subscriptionRepo;

	public SubscriptionService(SubscriptionRepository subscriptionRepo) {
		this.subscriptionRepo = subscriptionRepo;

	}

	// find
	public List<SubscriptionDTO> getSubscribersByUserId(String userId) {
        try {
            List<Subscription> subscriptions = subscriptionRepo.findByUserId(userId);

            if (subscriptions != null && !subscriptions.isEmpty()) {
                return subscriptions.stream()
                        .map(subscriptionAssembler::fromSubscriptionDTO)
                        .collect(Collectors.toList());
            } else {
            	System.out.println("NOT FOUND");
                return null; // or an empty list, throw an exception, or return a default DTO
            }
        } catch (Exception e) {
            // Handle the exception (log it, throw a custom exception, etc.)
            return null;
        }
    }

	
	public List<SubscriptionDTO> getAllSubscribers() {
        try {
            List<Subscription> allSubscribers = subscriptionRepo.findAllSubscribers();

            if (allSubscribers != null && !allSubscribers.isEmpty()) {
                return allSubscribers.stream()
                        .map(subscriptionAssembler::fromSubscriptionDTO)
                        .collect(Collectors.toList());
            } else {
                return null; // or an empty list, throw an exception, or return a default DTO
            }
        } catch (DataAccessException e) {
            // Log the data access exception or handle it as needed
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch Subscribers due to a data access issue. Please try again later.");
        } catch (Exception e) {
            // Log other exceptions or handle them as needed
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch Subscribers. Please try again later.");
        }
    }
}
