package com.algo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.algo.entity.Distributer;
import com.algo.service.DistributerService;

@RestController
@RequestMapping("/distributer")
public class DistrbuterController {
	@Autowired
	private DistributerService distributerService;

	public DistrbuterController(DistributerService distributerService) {
		this.distributerService = distributerService;

	}
	@PreAuthorize("hasRole('USERS') or hasRole('ADMIN')")
	@GetMapping("/distributerId")
	public ResponseEntity<?> getDistributerDetails(@RequestParam(name = "distributerId") String distributerId) {
	    try {
	        DistributerDTO distributerDTO = distributerService.getDistributer(distributerId);
	        // If the DTO is found, return it with HTTP status OK
	        return new ResponseEntity<>(distributerDTO, HttpStatus.OK);
	    } catch (Exception e) {
	        // If the DTO is not found, return HTTP status NOT_FOUND
	        return new ResponseEntity<>("Failed to fetch Distributer data.", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	@PreAuthorize("hasRole('USERS') or hasRole('ADMIN')")
	@GetMapping("/allDistributerList")
	public ResponseEntity<?> getAllDistributerList() {

		try {
			List<Distributer> distributers = distributerService.getAllDistributers();

			return distributers.isEmpty() ? new ResponseEntity<>("No Distributers found.", HttpStatus.NOT_FOUND)
					: new ResponseEntity<List<Distributer>>(distributers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to fetch Distributers data.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addDistributer")
	public ResponseEntity<String> addDistributerDetails(@RequestBody DistributerDTO distributerDTO) {

		try {
			String resultMessage = distributerService.addDistributer(distributerDTO);
			return new ResponseEntity<>(resultMessage, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Failed to add Distributer. Please check the input and try again.",
					HttpStatus.BAD_REQUEST);
		}
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/deactivateDistributer")
	public ResponseEntity<String> deactivateDistributer(@RequestParam(name = "distributerId") String distributerId) {
		try {

			distributerService.deactivateDistributer(distributerId);
			return new ResponseEntity<>("Distributer has been deactivated Successfully", HttpStatus.OK);
		} catch (Exception e) {
			// Log the exception or handle it as needed
			e.printStackTrace();
			return new ResponseEntity<>("Failed to deactivate distributer. Please check the input and try again.",
					HttpStatus.BAD_REQUEST);
		}
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/updateDistributer")
	public ResponseEntity<Map<String, Object>> updateDistributerDetails(@RequestParam(name = "distributerId") String distributerId,@RequestBody DistributerDTO distributerDTO) 
	{
	    try {
	        String updateResult = distributerService.updateDistributer(distributerId, distributerDTO);

	 
	      
	        // Create a map to represent the response
	        Map<String, Object> responseMap = new HashMap<>();
	        responseMap.put("updateResult", updateResult);
	        
	        // Return a response entity with the map
	        return new ResponseEntity<>(responseMap, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        Map<String, Object> errorMap = new HashMap<>();
	        errorMap.put("error", "Failed to update distributer. Please check the input and try again.");
	        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
	    }
	}
}
