package com.algo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algo.entity.SalesAdmin;

@Repository
public interface SalesAdminRepository extends JpaRepository<SalesAdmin, String>{

	
}