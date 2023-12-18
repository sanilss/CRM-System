package com.algo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algo.entity.UserInfo;
import com.algo.service.UsersJwtService;

@RestController
@RequestMapping("/usersInfo")
public class UserInfoController {

	@Autowired
	private UsersJwtService usersJwtService;

	public UserInfoController(UsersJwtService usersJwtService) {
		this.usersJwtService = usersJwtService;
	}
///note i have taken a case where anyone can add a user in SecurityConfig 
	@PostMapping("/new")

	public String addNewUser(@RequestBody UserInfo userInfo) {
		return usersJwtService.addUser(userInfo);
	}
}
