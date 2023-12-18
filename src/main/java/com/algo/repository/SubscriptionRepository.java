package com.algo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algo.entity.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, String>{
	@Query(value = "SELECT * FROM subcription WHERE UserID = :userId", nativeQuery = true)
    List<Subscription> findByUserId(@Param("userId") String userId);
	
	 @Query(value = "SELECT * FROM subcription", nativeQuery = true)
	    List<Subscription> findAllSubscribers();
	
} 
