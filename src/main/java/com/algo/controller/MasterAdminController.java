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

import com.algo.dto.MasterAdminDTO;
import com.algo.entity.MasterAdmin;
import com.algo.service.MasterAdminService;

@RestController
@RequestMapping("/masterAdmin")
public class MasterAdminController {
	@Autowired
	private MasterAdminService masterAdminService;

	public MasterAdminController(MasterAdminService masterAdminService) {
		this.masterAdminService = masterAdminService;
	}

	@PreAuthorize("hasRole('USERS') or hasRole('ADMIN')")
	@GetMapping("/masterAdminId")
	public ResponseEntity<?> getMasterAdminDetails(@RequestParam(name = "masterAdminId") String masterAdminId) {
		try {
			MasterAdminDTO masterAdminDTO = masterAdminService.getMasterAdmin(masterAdminId);
			return new ResponseEntity<>(masterAdminDTO, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Failed to fetch MasterAdmin data.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PreAuthorize("hasRole('USERS') or hasRole('ADMIN')")
	@GetMapping("/allMasterAdminList")
	public ResponseEntity<?> getAllMasterAdminList() {

		try {
			List<MasterAdmin> masterAdmins = masterAdminService.getAllMasterAdmins();

			return masterAdmins.isEmpty() ? new ResponseEntity<>("No MasterAdmin found.", HttpStatus.NOT_FOUND)
					: new ResponseEntity<List<MasterAdmin>>(masterAdmins, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to fetch MasterAdmin data.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addMasterAdmin")
	public ResponseEntity<String> addMasterAdminDetails(@RequestBody MasterAdminDTO masterAdminDTO) {

		try {
			String resultMessage = masterAdminService.addMasterAdmin(masterAdminDTO);		
			return new ResponseEntity<>(resultMessage, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Failed to add MasterAdmin. Please check the input and try again.",
					HttpStatus.BAD_REQUEST);
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/deactivateMasterAdmin")
	public ResponseEntity<String> deactivateDistributer(@RequestParam(name = "masterAdminId") String masterAdminId) {
		try {

			masterAdminService.deactivateMasterAdmin(masterAdminId);
			return new ResponseEntity<>("MasterAdmin has been deactivated Successfully", HttpStatus.OK);
		} catch (Exception e) {
			// Log the exception or handle it as needed
			e.printStackTrace();
			return new ResponseEntity<>("Failed to deactivate MasterAdmin. Please check the input and try again.",
					HttpStatus.BAD_REQUEST);
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/updateMasterAdmin")
	public ResponseEntity<String> updateDistributerDetails(@RequestParam(name = "masterAdminId") String masterAdminId,
			@RequestBody MasterAdminDTO masterAdminDTO) {

		try {
			masterAdminService.updateMasterAdmin(masterAdminId, masterAdminDTO);
			return new ResponseEntity<String>("MasterAdmin data has been updated Successfully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to update MasterAdmin. Please check the input and try again.",
					HttpStatus.BAD_REQUEST);
		}
	}

}
