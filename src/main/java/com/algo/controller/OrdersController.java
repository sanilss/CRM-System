package com.algo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.algo.dto.OrdersDTO;
import com.algo.service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	private OrdersService ordersService;

	public OrdersController(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	@PreAuthorize("hasRole('USERS') or hasRole('ADMIN')")
	@GetMapping("/orderId")
	public ResponseEntity<?> getOrderDetails(@RequestParam(name = "userId") String userId) {
		try {
			List<OrdersDTO> ordersDTO = ordersService.getOrdersByUserId(userId);
			// If the DTO is found, return it with HTTP status OK
			return new ResponseEntity<>(ordersDTO, HttpStatus.OK);
		} catch (Exception e) {
			// If the DTO is not found, return HTTP status NOT_FOUND
			return new ResponseEntity<>("Failed to fetch Order data.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PreAuthorize("hasRole('USERS') or hasRole('ADMIN')")
	@GetMapping("/allOrders")
	public ResponseEntity<?> getAllOrderDetails() {
		try {
			List<OrdersDTO> orders = ordersService.getAllOrders();

			// Check if the list is not empty before proceeding
			if (orders.isEmpty()) {
				return new ResponseEntity<>("No orders found.", HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<>(orders, HttpStatus.OK);
		} catch (Exception e) {
			// Log the exception or handle it as needed
			e.printStackTrace();
			return new ResponseEntity<>("Failed to fetch orders. Please try again later.",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
