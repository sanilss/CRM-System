package com.algo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algo.dto.DistributerDTO;
import com.algo.dto.RolesDTO;
import com.algo.dto.SummaryDTO;
import com.algo.service.SummaryService;

@RestController
@RequestMapping("/summary")
public class SummaryController {
@Autowired
private SummaryService summaryService;

public SummaryController(SummaryService summaryService) {
	this.summaryService=summaryService;
	}

@PreAuthorize("hasRole('USERS') or hasRole('ADMIN')")
@GetMapping("/summaryId")
public ResponseEntity<?> getSummaryDetails(@RequestParam(name = "summaryId") String summaryId) {
    try {
        SummaryDTO summaryDTO = summaryService.getUserSummary(summaryId);
        // If the DTO is found, return it with HTTP status OK
        return new ResponseEntity<>(summaryDTO, HttpStatus.OK);
    } catch (Exception e) {
        // If the DTO is not found, return HTTP status NOT_FOUND
        return new ResponseEntity<>("Failed to fetch Summary data.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@PreAuthorize("hasRole('USERS') or hasRole('ADMIN')")
@GetMapping("/allSummaryList")
public ResponseEntity<?> getAllSummaryList() {
    try {
        List<SummaryDTO> summaryList = summaryService.getAllSummary();
        return summaryList.isEmpty()
                ? new ResponseEntity<>("No Summary found.", HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(summaryList, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>("Failed to fetch Summary data.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


}
