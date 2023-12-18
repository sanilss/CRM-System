package com.algo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.algo.entity.Subscription;
import com.algo.entity.Trades;



public interface TradesRepository extends JpaRepository<Trades, String> {
	@Query(value = "SELECT * FROM trades WHERE Name = :name and Token= :token", nativeQuery = true)
    List<Trades> findByNameTokenAndDateTime(@Param("name") String name,@Param("token") String token);
	
	 @Query(value = "SELECT * FROM trades", nativeQuery = true)
	    List<Trades> findAllTrades();
}
