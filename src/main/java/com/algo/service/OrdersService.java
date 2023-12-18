package com.algo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.algo.assembler.OrdersAssembler;
import com.algo.dto.OrdersDTO;
import com.algo.entity.Orders;
import com.algo.repository.OrdersRepository;


@Service
public class OrdersService {
 OrdersAssembler ordersAssembler=new OrdersAssembler();
 private final OrdersRepository ordersRepo;
 
 public OrdersService(OrdersRepository ordersRepo) {
		this.ordersRepo = ordersRepo;

	}
 
 
//find
	public List<OrdersDTO> getOrdersByUserId(String userId) {
      try {
          List<Orders> orders = ordersRepo.findByUserId(userId);

          if (orders != null && !orders.isEmpty()) {
              return orders.stream()
                      .map(ordersAssembler::fromOrdersDTO)
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
 
	//find all
	public List<OrdersDTO> getAllOrders() {
        try {
            List<Orders> allOrders = ordersRepo.findAllOrders();

            if (allOrders != null && !allOrders.isEmpty()) {
                return allOrders.stream()
                        .map(ordersAssembler::fromOrdersDTO)
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
