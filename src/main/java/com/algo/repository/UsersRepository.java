package com.algo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algo.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String>{
	@Query(value = "SELECT * FROM sign_up_temp WHERE UserID = :userId", nativeQuery = true)
    Users findByUserId(@Param("userId") String userId);
	
	 @Query(value = "SELECT * FROM sign_up_temp", nativeQuery = true)
	    List<Users> findAllUsers();
}
