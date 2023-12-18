package com.algo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.algo.entity.Roles;
@Repository
public interface RolesRepository extends JpaRepository<Roles, String>{

	
}
