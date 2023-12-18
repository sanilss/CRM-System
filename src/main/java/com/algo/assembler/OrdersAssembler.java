package com.algo.assembler;

import com.algo.dto.OrdersDTO;
import com.algo.entity.Orders;

public class OrdersAssembler {

	private Orders orders;
	private OrdersDTO ordersDTO;
	
	
	public Orders toOrders(OrdersDTO ordersDTO) {
		 orders=new Orders();
		
		Orders.OrderIdAndDate orderIdAndDate=new Orders.OrderIdAndDate();
		orders.setOrderIdAndDate(orderIdAndDate);	
		orders.getOrderIdAndDate().setUserId(ordersDTO.getUserId());
		orders.setSymbol(ordersDTO.getSymbol());
		orders.setToken(ordersDTO.getToken());
		orders.setPrice(ordersDTO.getPrice());
		orders.setQuantity(orders.getQuantity());
		orders.setType(ordersDTO.getType());
		orders.getOrderIdAndDate().setDateTime(ordersDTO.getDateTime());
		
		return orders;
		}
	
	public OrdersDTO fromOrdersDTO(Orders orders) {
		   ordersDTO = new OrdersDTO();
		  ordersDTO.setUserId(orders.getOrderIdAndDate().getUserId());
		  ordersDTO.setSymbol(orders.getSymbol());
		  ordersDTO.setToken(orders.getToken());
		  ordersDTO.setPrice(orders.getPrice());
		  ordersDTO.setQuantity(orders.getQuantity());
		  ordersDTO.setType(orders.getType());
		  ordersDTO.setDateTime(orders.getOrderIdAndDate().getDateTime());
		  
		  return ordersDTO;
		  }
}
