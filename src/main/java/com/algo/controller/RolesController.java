package com.algo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.algo.dto.RolesDTO;
import com.algo.service.RolesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/roles")
public class RolesController {
	@Autowired
	private RolesService rolesService;

	public RolesController(RolesService rolesService) {
		this.rolesService = rolesService;
	}

	@PreAuthorize("hasRole('USERS') or hasRole('ADMIN')")
	@GetMapping("/getroles")
	public ResponseEntity<?> getRolesDetails(@RequestParam(name = "id") String id) {
		try {
			RolesDTO rolesDTO = rolesService.getRoles(id);
			return new ResponseEntity<>(rolesDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to fetch roles data.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PreAuthorize("hasRole('USERS') or hasRole('ADMIN')")
	@GetMapping("/allRolesList")
	public ResponseEntity<?> getAllRolesList() {
		try {
			List<RolesDTO> roles = rolesService.getAllRoles();
			return roles.isEmpty() ? new ResponseEntity<>("No roles found.", HttpStatus.NOT_FOUND)
					: new ResponseEntity<>(roles, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to fetch roles data.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addRoles")
	public ResponseEntity<String> addRoles(@RequestBody @Valid RolesDTO rolesDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>("Invalid request. Please check the input keys and values.",
					HttpStatus.BAD_REQUEST);
		}

		try {
			String resultMessage = rolesService.addRoles(rolesDTO);
			return new ResponseEntity<>(resultMessage, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to add roles. Please check the input and try again.",
					HttpStatus.BAD_REQUEST);
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/updateRoles")
	public ResponseEntity<String> updateRoles(@RequestParam(name = "id") String id,
			@RequestBody @Valid RolesDTO rolesDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>("Invalid request. Please check the input keys and values.",
					HttpStatus.BAD_REQUEST);
		}

		try {
			String resultMsg = rolesService.updateRoles(id, rolesDTO);
			return new ResponseEntity<>(resultMsg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to update roles data. Please check the input and try again.",
					HttpStatus.BAD_REQUEST);
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/deleteRoles")
	public ResponseEntity<String> deleteRoles(@RequestParam(name = "id") String id) {
		try {
			String resultMsg = rolesService.deleteRoles(id);
			return new ResponseEntity<>(resultMsg, HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to delete roles. Please check the input and try again.",
					HttpStatus.BAD_REQUEST);
		}
	}

}
