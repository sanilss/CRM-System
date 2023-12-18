package com.algo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.algo.assembler.TradesAssembler;
import com.algo.dto.SubscriptionDTO;
import com.algo.dto.TradesDTO;
import com.algo.entity.Subscription;
import com.algo.entity.Trades;
import com.algo.repository.TradesRepository;

@Service
public class TradesService {
	TradesAssembler tradesAssembler = new TradesAssembler();
	private final TradesRepository tradesRepo;

	public TradesService(TradesRepository tradesRepo) {

		this.tradesRepo = tradesRepo;
	}

	public List<TradesDTO> getTradesByTradesId(String name, String token) {
		try {
			List<Trades> trades = tradesRepo.findByNameTokenAndDateTime(name, token);
			if (trades != null && !trades.isEmpty()) {
				return trades.stream().map(tradesAssembler::fromTradesDTO).collect(Collectors.toList());
			} else {
				System.out.println("NOT FOUND");
				return null; // or an empty list, throw an exception, or return a default DTO
			}
		} catch (Exception e) {
			// Handle the exception (log it, throw a custom exception, etc.)
			return null;

		}
	}
	
	public List<TradesDTO> getAllTrades() {
        try {
            List<Trades> allTrades = tradesRepo.findAllTrades();

            if (allTrades != null && !allTrades.isEmpty()) {
                return allTrades.stream()
                        .map(tradesAssembler::fromTradesDTO)
                        .collect(Collectors.toList());
            } else {
                return null; // or an empty list, throw an exception, or return a default DTO
            }
        } catch (DataAccessException e) {
            // Log the data access exception or handle it as needed
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch Trades due to a data access issue. Please try again later.");
        } catch (Exception e) {
            // Log other exceptions or handle them as needed
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch Trades. Please try again later.");
        }
    }
	
	
}