package com.algo.assembler;

import com.algo.dto.OrdersDTO;
import com.algo.dto.TradesDTO;
import com.algo.entity.Trades;

public class TradesAssembler {

	private Trades trades;
	private TradesDTO tradesDTO;

	public Trades toTrades(TradesDTO tradesDTO) {
		trades = new Trades();

		Trades.TradesId tradesId = new Trades.TradesId();
		trades.setTradesId(tradesId);

		trades.getTradesId().setToken(tradesDTO.getToken());
		trades.getTradesId().setDateTime(tradesDTO.getDateTime());	
		trades.getTradesId().setName(tradesDTO.getName());
		trades.setIndexPrice(tradesDTO.getIndexPrice());
		trades.setPosition(tradesDTO.getPosition());
		trades.setType(tradesDTO.getType());
		trades.setQuantity(tradesDTO.getQuantity());
		trades.setPrice(tradesDTO.getPrice());
		trades.setStratergy(tradesDTO.getStratergy());

		return trades;
	}

	public TradesDTO fromTradesDTO(Trades trades) {

		tradesDTO = new TradesDTO();
		tradesDTO.setToken(trades.getTradesId().getToken());
		tradesDTO.setDateTime(trades.getTradesId().getDateTime());		
		tradesDTO.setName(trades.getTradesId().getName());
		tradesDTO.setIndexPrice(trades.getIndexPrice());
		tradesDTO.setPosition(trades.getPosition());
		tradesDTO.setType(trades.getType());
		tradesDTO.setQuantity(trades.getQuantity());
		tradesDTO.setPrice(trades.getPrice());
		tradesDTO.setStratergy(trades.getStratergy());

		return tradesDTO;
	}
}
