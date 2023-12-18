package com.algo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.algo.dto.MasterDistributerDTO;
import com.algo.entity.MasterDistributer;
import com.algo.service.MasterDistributerService;

@Controller  // Add this annotation
@RequestMapping("/masterDistributer")
public class MasterDistributerController {

	@Autowired
	private MasterDistributerService masterDistributerService;

	public MasterDistributerController(MasterDistributerService masterDistributerService) {

		this.masterDistributerService = masterDistributerService;
	}
	@PreAuthorize("hasRole('USERS') or hasRole('ADMIN')")
	@GetMapping("/masterDistributerId")
	public ResponseEntity<?> getMasterDistributerDetails(@RequestParam(name = "masterDistributerId") String masterDistributerId) {

		try {
			MasterDistributerDTO masterDistributerDTO = masterDistributerService
					.getMasterDistributer(masterDistributerId);
			// If the DTO is found, return it with HTTP status OK
			return new ResponseEntity<>(masterDistributerDTO, HttpStatus.OK);
		} catch (Exception e) {
			// If the DTO is not found, return HTTP status NOT_FOUND
			return new ResponseEntity<>("Failed to fetch Distributer data.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@PreAuthorize("hasRole('USERS') or hasRole('ADMIN')")
	@GetMapping("/allMasterDistributerList")
	public ResponseEntity<?> getAllMasterDistributerList() {

		try {
			List<MasterDistributer> masterDistributers = masterDistributerService.getAllMasterDistributers();

			return masterDistributers.isEmpty() ? new ResponseEntity<>("No Distributers found.", HttpStatus.NOT_FOUND)
					: new ResponseEntity<List<MasterDistributer>>(masterDistributers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to fetch Distributers data.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addMasterDistributer")
	public ResponseEntity<String> addMasterDistributerDetails(@RequestBody MasterDistributerDTO masterDistributerDTO) {
		try {
			String resultMessage = masterDistributerService.addMasterDistributer(masterDistributerDTO);
			 
			return new ResponseEntity<>(resultMessage, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to add MasterDistributer. Please check the input and try again.",
					HttpStatus.BAD_REQUEST);
		}
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/deactivateMasterDistributer")
	public ResponseEntity<String> deactivateDistributer(
			@RequestParam(name = "masterDistributerId") String masterDistributerId) {
		try {

			masterDistributerService.deactivateMasterDistributer(masterDistributerId);
			return new ResponseEntity<>("Distributer has been deactivated Successfully", HttpStatus.OK);
		} catch (Exception e) {
			// Log the exception or handle it as needed
			e.printStackTrace();
			return new ResponseEntity<>("Failed to deactivate MasterDistributer. Please check the input and try again.",
					HttpStatus.BAD_REQUEST);
		}
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/updateMasterDistributer")
	public ResponseEntity<Map<String, Object>> updateMasterDistributerDetails(
	    @RequestParam(name = "masterDistributerId") String masterDistributerId,
	    @RequestBody MasterDistributerDTO masterDistributerDTO
	) {
	    try {
	        String updateResult = masterDistributerService.updateMasterDistributer(masterDistributerId, masterDistributerDTO);

	        // Check if the result contains the message for invalid SALREF
	        if (updateResult.contains("Invalid SALREF value provided")) {
	            Map<String, Object> errorMap = new HashMap<>();
	            errorMap.put("error", updateResult);
	            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
	        }

	        // Create a map to represent the response
	        Map<String, Object> responseMap = new HashMap<>();
	        responseMap.put("updateResult", updateResult);

	        // Return a response entity with the map
	        return new ResponseEntity<>(responseMap, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        Map<String, Object> errorMap = new HashMap<>();
	        errorMap.put("error", "Failed to update MasterDistributer. Please check the input and try again.");
	        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
	    }
	}


}
