package com.algo.assembler;

import com.algo.dto.CommissionDTO;
import com.algo.entity.Commission;

public class CommissionAssembler {

	private CommissionDTO commissionDTO;
	private Commission commission;

	public Commission toCommission(CommissionDTO commissionDTO) {

		commission = new Commission();
		commission.setId(commissionDTO.getId());
		commission.setDistributerCommission(commissionDTO.getDistributerCommission());
		commission.setMasterAdminCommission(commissionDTO.getMasterAdminCommission());
		commission.setSalesAdminCommission(commissionDTO.getSalesAdminCommission());

		return commission;

	}

	public CommissionDTO fromCommission(Commission commission) {
		commissionDTO = new CommissionDTO();

		commissionDTO.setId(commissionDTO.getId());
		commissionDTO.setDistributerCommission(commission.getDistributerCommission());
		commissionDTO.setMasterAdminCommission(commission.getMasterAdminCommission());
		commissionDTO.setSalesAdminCommission(commission.getSalesAdminCommission());

		return commissionDTO;
	}

}
