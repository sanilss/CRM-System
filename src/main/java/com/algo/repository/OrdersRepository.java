package com.algo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algo.entity.Orders;
import com.algo.entity.Subscription;


@Repository
public interface OrdersRepository extends JpaRepository<Orders, String>{
	@Query(value = "SELECT * FROM orders WHERE UserID = :userId", nativeQuery = true)
    List<Orders> findByUserId(@Param("userId") String userId);
	
	 @Query(value = "SELECT * FROM orders", nativeQuery = true)
	    List<Orders> findAllOrders();
}
