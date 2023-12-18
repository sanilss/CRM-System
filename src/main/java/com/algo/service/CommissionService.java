package com.algo.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.algo.assembler.CommissionAssembler;
import com.algo.dto.CommissionDTO;
import com.algo.entity.Commission;
import com.algo.repository.CommissionRepository;

@Service
public class CommissionService {

	CommissionAssembler commissionAssembler = new CommissionAssembler();
	private final CommissionRepository commissionRepo;

	public CommissionService(CommissionRepository commissionRepo) {
		this.commissionRepo = commissionRepo;
	}

	public CommissionDTO getCommission(String commissionId) {
		try {

			Commission commission = commissionRepo.findById(commissionId).get();
			CommissionDTO commissionDTO = commissionAssembler.fromCommission(commission);
			return commissionDTO;
		} catch (Exception e) {

			throw new RuntimeException("An error occurred while fetching the Commission.", e);
		}
	}

	public List<CommissionDTO> getAllCommission() {
		try {
			List<Commission> allCommission = commissionRepo.findAll();
			List<CommissionDTO> allCommissionDTO = allCommission.stream().map(commissionAssembler::fromCommission)
					.collect(Collectors.toList());
			return allCommissionDTO;
		} catch (Exception e) {
			throw new RuntimeException("An error occurred while fetching all commission.", e);
		}
	}

}
