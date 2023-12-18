package com.algo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.algo.assembler.UsersAssembler;
import com.algo.dto.UsersDTO;
import com.algo.entity.Users;
import com.algo.repository.RolesRepository;
import com.algo.repository.UsersRepository;

@Service
public class UsersService {
UsersAssembler usersAssembler=new UsersAssembler();
private final UsersRepository usersRepo;

public UsersService(UsersRepository usersRepo) {
	this.usersRepo = usersRepo;
}
	
public UsersDTO getUser(String userId) throws Exception {
    try {
        Users user = usersRepo.findByUserId(userId);
        
        if (user != null) {
            UsersDTO usersDTO = usersAssembler.fromUsersDTO(user);
         // Mask the password
            usersDTO.setPassword("*****");
            return usersDTO;
        } else {
            // Handle the case where the user with the given userId is not found
            // You can throw an exception or return null, depending on your requirements
            // For example, you might throw a custom exception like UserNotFoundException
            throw new Exception("User with userId " + userId + " not found");
        }
    } catch (Exception e) {
        // Handle other exceptions, log them, or rethrow if needed
        throw new Exception("Failed to fetch user data for userId: " + userId, e);
    }
}

public List<UsersDTO> getAllUsers() throws Exception {
    try {
        List<Users> userList = usersRepo.findAllUsers();
        
        if (!userList.isEmpty()) {
        	 List<UsersDTO> usersDTOList = new ArrayList<>();

             for (Users user : userList) {
                 UsersDTO usersDTO = usersAssembler.fromUsersDTO(user);
                 // Mask the password
                 usersDTO.setPassword("*****");
                 usersDTOList.add(usersDTO);
             }

             return usersDTOList;
        } else {
            // You can throw an exception or return an empty list, depending on your requirements
            // For example, you might throw a custom exception like UsersNotFoundException
            throw new Exception("No users found");
        }
    } catch (Exception e) {
        // Handle other exceptions, log them, or rethrow if needed
        throw new Exception("Failed to fetch user data", e);
    }
}



}
