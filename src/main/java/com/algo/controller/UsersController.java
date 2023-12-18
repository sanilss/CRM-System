package com.algo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.AuthorizeRequestsDsl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algo.dto.AuthRequestDTO;
import com.algo.dto.RolesDTO;
import com.algo.dto.UsersDTO;
import com.algo.service.JwtService;
import com.algo.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

	private UsersService usersService;
	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}

	@PreAuthorize("hasRole('USERS') or hasRole('ADMIN')")
	@GetMapping("/getuser")
	public ResponseEntity<?> getUsersDetails(@RequestParam(name = "userId") String userId) {
		try {
			UsersDTO usersDTO = usersService.getUser(userId);
			return new ResponseEntity<>(usersDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to fetch Users data.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PreAuthorize("hasRole('USERS') or hasRole('ADMIN')")
	@GetMapping("/allUsersList")
	public ResponseEntity<?> getAllUsersList() {
		try {
			List<UsersDTO> users = usersService.getAllUsers();
			return users.isEmpty()

					? new ResponseEntity<>("No User found.", HttpStatus.NOT_FOUND)
					: new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to fetch User data.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
/////related to JWT
	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(authRequestDTO.getUsername());
		} else {
			throw new UsernameNotFoundException("Invalid user request!!!!!");
		}
	}

}
