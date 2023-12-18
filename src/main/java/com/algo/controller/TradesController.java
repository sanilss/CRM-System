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
import com.algo.dto.TradesDTO;
import com.algo.service.TradesService;
@RestController
@RequestMapping("/trades")
public class TradesController {

	private TradesService tradesService;

	public TradesController(TradesService tradesService) {
		this.tradesService = tradesService;
	}
	
	@PreAuthorize("hasRole('USERS') or hasRole('ADMIN')")
	@GetMapping("/tradesId")
	public ResponseEntity<?>getTradesByTradesId(
            @RequestParam String name,
            @RequestParam String token
            ) {
		try {
			List<TradesDTO> tradesDTOList  = tradesService.getTradesByTradesId(name,token);
			// If the DTO is found, return it with HTTP status OK
			return new ResponseEntity<>(tradesDTOList , HttpStatus.OK);
		} catch (Exception e) {
			// If the DTO is not found, return HTTP status NOT_FOUND
			return new ResponseEntity<>("Failed to fetch Subscriber data.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PreAuthorize("hasRole('USERS') or hasRole('ADMIN')")
	@GetMapping("/allTrades")
	public ResponseEntity<?> getAllTradeDetails() {
		try {
			List<TradesDTO> trades = tradesService.getAllTrades();

			// Check if the list is not empty before proceeding
			if (trades.isEmpty()) {
				return new ResponseEntity<>("No trades found.", HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<>(trades, HttpStatus.OK);
		} catch (Exception e) {
			// Log the exception or handle it as needed
			e.printStackTrace();
			return new ResponseEntity<>("Failed to fetch trades. Please try again later.",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
}