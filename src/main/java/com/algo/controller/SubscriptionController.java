package com.algo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algo.dto.SubscriptionDTO;
import com.algo.service.SubscriptionService;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

	private SubscriptionService subscriptionService;

	public SubscriptionController(SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}

	@PreAuthorize("hasRole('USERS') or hasRole('ADMIN')")
	@GetMapping("/userId")
	public ResponseEntity<?> getSubscriberDetails(@RequestParam(name = "userId") String userId) {
		try {
			List<SubscriptionDTO> subscriptionDTO = subscriptionService.getSubscribersByUserId(userId);
			// If the DTO is found, return it with HTTP status OK
			return new ResponseEntity<>(subscriptionDTO, HttpStatus.OK);
		} catch (Exception e) {
			// If the DTO is not found, return HTTP status NOT_FOUND
			return new ResponseEntity<>("Failed to fetch Subscriber data.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PreAuthorize("hasRole('USERS') or hasRole('ADMIN')")
	@GetMapping("/allSubscriber")
	public ResponseEntity<?> getAllSubscriberDetails() {
		try {
			List<SubscriptionDTO> subscriptions = subscriptionService.getAllSubscribers();

			// Check if the list is not empty before proceeding
			if (subscriptions.isEmpty()) {
				return new ResponseEntity<>("No subscribers found.", HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<>(subscriptions, HttpStatus.OK);
		} catch (Exception e) {
			// Log the exception or handle it as needed
			e.printStackTrace();
			return new ResponseEntity<>("Failed to fetch subscribers. Please try again later.",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
