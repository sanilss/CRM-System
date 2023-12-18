package com.algo.assembler;

import com.algo.dto.SummaryDTO;
import com.algo.entity.Summary;

public class SummaryAssembler {
    private Summary summary;
    private SummaryDTO summaryDTO;

    public Summary toSummary(SummaryDTO summaryDTO) {
        summary = new Summary();
        summary.setId(summaryDTO.getId());
        summary.setSymbol(summaryDTO.getSymbol());
        summary.setToken(summaryDTO.getToken());
        summary.setPrice(summaryDTO.getPrice());
        summary.setQuantity(summaryDTO.getQuantity());
        summary.setType(summaryDTO.getType());
        summary.setDateTime(summaryDTO.getDateTime());
        summary.setCommissionIdDIS(summaryDTO.getCommissionIdDIS());
        summary.setCommissionOfDIS(summaryDTO.getCommissionOfDIS());
        summary.setCommissionIdMD(summaryDTO.getCommissionIdMD());
        summary.setCommissionOfMD(summaryDTO.getCommissionOfMD());
        summary.setCommissionIDSA(summaryDTO.getCommissionIDSA());
        summary.setCommissionOfSA(summaryDTO.getCommissionOfSA());

        return summary;
    }

    public SummaryDTO fromSummary(Summary summary) {
        summaryDTO = new SummaryDTO();
        summaryDTO.setId(summary.getId());
        summaryDTO.setSymbol(summary.getSymbol());
        summaryDTO.setToken(summary.getToken());
        summaryDTO.setPrice(summary.getPrice());
        summaryDTO.setQuantity(summary.getQuantity());
        summaryDTO.setType(summary.getType());
        summaryDTO.setDateTime(summary.getDateTime());
        summaryDTO.setCommissionIdDIS(summary.getCommissionIdDIS());
        summaryDTO.setCommissionOfDIS(summary.getCommissionOfDIS());
        summaryDTO.setCommissionIdMD(summary.getCommissionIdMD());
        summaryDTO.setCommissionOfMD(summary.getCommissionOfMD());
        summaryDTO.setCommissionIDSA(summary.getCommissionIDSA());
        summaryDTO.setCommissionOfSA(summary.getCommissionOfSA());

        return summaryDTO;
    }
}
