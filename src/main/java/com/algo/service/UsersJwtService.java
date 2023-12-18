package com.algo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.algo.entity.UserInfo;
import com.algo.repository.UserInfoRepository;

@Service
public class UsersJwtService {
	@Autowired
  private UserInfoRepository repository;
	@Autowired
	private BCryptPasswordEncoder byBCryptPasswordEncoder;
	
	
	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(byBCryptPasswordEncoder.encode(userInfo.getPassword()));
		repository.save(userInfo);
		return "user added to System";
	}
}
