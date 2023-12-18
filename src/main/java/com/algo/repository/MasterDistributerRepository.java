package com.algo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algo.entity.MasterDistributer;
@Repository
public interface MasterDistributerRepository extends JpaRepository<MasterDistributer, String> {

}
