package com.algo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algo.entity.Commission;
@Repository
public interface CommissionRepository extends JpaRepository<Commission, String> {

}
