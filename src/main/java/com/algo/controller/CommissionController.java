package com.algo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.algo.dto.CommissionDTO;
import com.algo.service.CommissionService;

@RestController
@RequestMapping("/commission")
public class CommissionController {
	private CommissionService commissionService;

	public CommissionController(CommissionService commissionService) {
		this.commissionService = commissionService;

	}
	
	@PreAuthorize("hasRole('USERS') or hasRole('ADMIN')")
	@GetMapping("/getCommission")
	public ResponseEntity<?> getCommissionDetails(@RequestParam(name = "commissionId") String commissionId) {
		try {
			CommissionDTO commissionDTO = commissionService.getCommission(commissionId);
			return new ResponseEntity<>(commissionDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to fetch commission data.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PreAuthorize("hasRole('USERS') or hasRole('ADMIN')")
	@GetMapping("/allCommissionList")
	public ResponseEntity<?> getAllCommissionList() {
		try {
			List<CommissionDTO> commission = commissionService.getAllCommission();
			return commission.isEmpty() ? new ResponseEntity<>("No commission found.", HttpStatus.NOT_FOUND)
					: new ResponseEntity<>(commission, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to fetch commission data.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}