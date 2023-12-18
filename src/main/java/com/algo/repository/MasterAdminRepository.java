package com.algo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algo.entity.MasterAdmin;
import com.algo.entity.Roles;

public interface MasterAdminRepository extends JpaRepository<MasterAdmin, String>{

	
}
