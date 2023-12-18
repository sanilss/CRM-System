package com.algo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algo.dto.DistributerDTO;
import com.algo.dto.SalesAdminDTO;
import com.algo.entity.Distributer;
import com.algo.entity.SalesAdmin;
import com.algo.service.DistributerService;
import com.algo.service.SalesAdminService;

@RestController
@RequestMapping("/salesAdmin")

public class SalesAdminController {
 private SalesAdminService salesAdminService;
 
 public SalesAdminController(SalesAdminService salesAdminService) {
	 this.salesAdminService=salesAdminService;
	 
 }
 
	@PreAuthorize("hasRole('USERS') or hasRole('ADMIN')")
 @GetMapping("/salesAdminId")
 public ResponseEntity<?> getSalesAdminDetails(@RequestParam(name="salesAdminId") String salesAdminId){
	 try {
		 SalesAdminDTO salesAdminDTO=salesAdminService.getSalesAdmin(salesAdminId);
		// If the DTO is found, return it with HTTP status OK
		 return new ResponseEntity<>(salesAdminDTO, HttpStatus.OK);
	 }catch(Exception e) {
		// If the DTO is not found, return HTTP status NOT_FOUND
					return new ResponseEntity<>("Failed to fetch SalesAdmin data.", HttpStatus.INTERNAL_SERVER_ERROR);
	 }
	 
 }
 
	@PreAuthorize("hasRole('USERS') or hasRole('ADMIN')")

 @GetMapping("/allSalesAdminList")
	public ResponseEntity<?> getAllDistributerList() {

		try {
			List<SalesAdmin> salesAdmins = salesAdminService.getAllSalesAdmins();

			return salesAdmins.isEmpty() ? new ResponseEntity<>("No Distributers found.", HttpStatus.NOT_FOUND)
					: new ResponseEntity<List<SalesAdmin>>(salesAdmins, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to fetch SalesAdmins data.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PreAuthorize("hasRole('ADMIN')")
 @PostMapping("/addSalesAdmin")
	public ResponseEntity<String> addSalesAdminDetails(@RequestBody SalesAdminDTO salesAdminDTO) {

		try {
			String resultMessage = salesAdminService.addSalesAdmin(salesAdminDTO);
			return new ResponseEntity<>(resultMessage, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Failed to add SalesAdmin. Please check the input and try again.",
					HttpStatus.BAD_REQUEST);
		}
	}
	@PreAuthorize("hasRole('ADMIN')")
 @PostMapping("/deactivateSalesAdmin")
	public ResponseEntity<String> deactivateSalesAdmin(@RequestParam(name = "salesAdminId") String salesAdminId) {
		try {

			salesAdminService.deactivateSalesAdmin(salesAdminId);
			return new ResponseEntity<>("SalesAdmin has been deactivated Successfully", HttpStatus.OK);
		} catch (Exception e) {
			// Log the exception or handle it as needed
			e.printStackTrace();
			return new ResponseEntity<>("Failed to deactivate SalesAdmin. Please check the input and try again.",
					HttpStatus.BAD_REQUEST);
		}
	}
	@PreAuthorize("hasRole('ADMIN')")
 @PostMapping("/updateSalesAdmin")
	public ResponseEntity<String> updateDistributerDetails(@RequestParam(name = "salesAdminId") String salesAdminId,
			@RequestBody SalesAdminDTO salesAdminDTO) {

		try {
			salesAdminService.updateSalesAdmin(salesAdminId, salesAdminDTO);
			return new ResponseEntity<String>("Distributer data has been updated Successfully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to update distributer. Please check the input and try again.",
					HttpStatus.BAD_REQUEST);
		}
	}
 
 
 
}
