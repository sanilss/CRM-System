package com.algo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.algo.assembler.RolesAssembler;
import com.algo.assembler.SummaryAssembler;
import com.algo.dto.RolesDTO;
import com.algo.dto.SummaryDTO;
import com.algo.entity.Roles;
import com.algo.entity.Summary;
import com.algo.repository.RolesRepository;
import com.algo.repository.SummaryRepository;

@Service
public class SummaryService {
	SummaryAssembler summaryAssembler = new SummaryAssembler();
	private final SummaryRepository summaryRepo;

	public SummaryService(SummaryRepository summaryRepo) {
		this.summaryRepo = summaryRepo;
	}
	
	
	public SummaryDTO getUserSummary(String summaryId) {

		try {
		Summary	summary=summaryRepo.findById(summaryId).get();
		SummaryDTO summaryDTO=summaryAssembler.fromSummary(summary);
		return summaryDTO;
		} catch (Exception e) {
			throw new RuntimeException("An error occurred while fetching the Summary.", e);
		}
	}
	
	public List<SummaryDTO> getAllSummary() {
		try {
			List<Summary> allSummary = summaryRepo.findAll();
			List<SummaryDTO> allSummaryDTO = allSummary.stream().map(summaryAssembler::fromSummary).collect(Collectors.toList());
			return allSummaryDTO;
		} catch (Exception e) {
			throw new RuntimeException("An error occurred while fetching all Summary.", e);
		}
	}
	
	
	
}