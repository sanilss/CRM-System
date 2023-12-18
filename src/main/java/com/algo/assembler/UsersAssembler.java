package com.algo.assembler;

import com.algo.dto.UsersDTO;
import com.algo.entity.Users;

public class UsersAssembler {

	private Users users;
	private UsersDTO usersDTO;

	public Users toUsers(UsersDTO usersDTO) {
		users = new Users();

		users.setUserId(usersDTO.getUserId());
		users.setCreatedBy(usersDTO.getCreatedBy());
		users.setCreatedDate(usersDTO.getCreatedDate());
		users.setDateAndTime(usersDTO.getDateAndTime());
		users.setDob(usersDTO.getDob());
		users.setEmail(usersDTO.getEmail());
		users.setMobile(usersDTO.getMobile());
		users.setModifiedBy(usersDTO.getModifiedBy());
		users.setModifiedDate(usersDTO.getModifiedDate());
		users.setName(usersDTO.getName());
		users.setPassword(usersDTO.getPassword());
		users.setReferralAccountBy(usersDTO.getReferralAccountBy());
		users.setReferralAccountById(usersDTO.getReferralAccountById());

		users.setReferralAccountStatus(usersDTO.getReferralAccountStatus());
		users.setSubscriptionStatus(usersDTO.getSubscriptionStatus());
		users.setVersion(usersDTO.getVersion());
		users.setWelcome(usersDTO.getWelcome());

		return users;
	}

	public UsersDTO fromUsersDTO(Users users) {
		usersDTO=new UsersDTO();
		
		usersDTO.setUserId(users.getUserId());
		usersDTO.setCreatedBy(users.getCreatedBy());
		usersDTO.setCreatedDate(users.getCreatedDate());
		usersDTO.setDateAndTime(users.getDateAndTime());
		usersDTO.setDob(users.getDob());
		usersDTO.setEmail(users.getEmail());
		usersDTO.setMobile(users.getMobile());
		usersDTO.setModifiedBy(users.getModifiedBy());
		usersDTO.setModifiedDate(users.getModifiedDate());
		usersDTO.setName(users.getName());
		usersDTO.setPassword(users.getPassword());
		usersDTO.setReferralAccountBy(users.getReferralAccountBy());
		usersDTO.setReferralAccountById(users.getReferralAccountById());

		usersDTO.setReferralAccountStatus(users.getReferralAccountStatus());
		usersDTO.setSubscriptionStatus(users.getSubscriptionStatus());
		usersDTO.setVersion(users.getVersion());
		usersDTO.setWelcome(users.getWelcome());

		return usersDTO;	}
	
	
}
