package com.algo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algo.entity.Roles;
import com.algo.entity.Summary;

public interface SummaryRepository extends JpaRepository<Summary, String> {

}
