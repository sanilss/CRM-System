package com.algo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algo.entity.Distributer;
@Repository
public interface DistributerRepository extends JpaRepository<Distributer, String>{

	
}
