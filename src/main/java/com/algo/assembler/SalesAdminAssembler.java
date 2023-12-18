package com.algo.assembler;

import com.algo.dto.SalesAdminDTO;
import com.algo.entity.SalesAdmin;

public class SalesAdminAssembler {

	private SalesAdmin salesAdminEntity;
	private SalesAdminDTO salesAdminDTO;

	public SalesAdmin toSalesAdmin(SalesAdminDTO salesAdminDTO) {
		salesAdminEntity = new SalesAdmin();
		
		salesAdminEntity.setId(salesAdminDTO.getId());		
		salesAdminEntity.setName(salesAdminDTO.getName());
		salesAdminEntity.setUsername(salesAdminDTO.getUsername());
		salesAdminEntity.setPassword(salesAdminDTO.getPassword());
		salesAdminEntity.setMobile(salesAdminDTO.getMobile());
		salesAdminEntity.setEmail(salesAdminDTO.getEmail());
		salesAdminEntity.setDob(salesAdminDTO.getDob());
		salesAdminEntity.setRefCode(salesAdminDTO.getRefCode());
		salesAdminEntity.setEmpStatus(salesAdminDTO.getEmpStatus());
		salesAdminEntity.setComissionAmount(salesAdminDTO.getComissionAmount());
		salesAdminEntity.setComissionPercent(salesAdminDTO.getComissionPercent());
		salesAdminEntity.setReferralAccountStatus(salesAdminDTO.getReferralAccountStatus());
		salesAdminEntity.setRole(salesAdminDTO.getRole());
		salesAdminEntity.setActive(salesAdminDTO.getisActive());

		salesAdminEntity.setCreatedBy(salesAdminDTO.getCreatedBy());
		salesAdminEntity.setCreatedDate(salesAdminDTO.getCreatedDate());
		salesAdminEntity.setModifiedBy(salesAdminDTO.getModifiedBy());
		salesAdminEntity.setModifiedDate(salesAdminDTO.getModifiedDate());
		salesAdminEntity.setVersion(salesAdminDTO.getVersion());


		return salesAdminEntity;
	}

	public SalesAdminDTO fromSalesAdmin(SalesAdmin salesAdminEntity) {
		//
		salesAdminDTO = new SalesAdminDTO();

		salesAdminDTO.setId(salesAdminEntity.getId());
		salesAdminDTO.setName(salesAdminEntity.getName());
		salesAdminDTO.setUsername(salesAdminEntity.getUsername());
		salesAdminDTO.setPassword(salesAdminEntity.getPassword());
		salesAdminDTO.setMobile(salesAdminEntity.getMobile());
		salesAdminDTO.setEmail(salesAdminEntity.getEmail());
		salesAdminDTO.setDob(salesAdminEntity.getDob());
		salesAdminDTO.setRefCode(salesAdminEntity.getRefCode());
		salesAdminDTO.setEmpStatus(salesAdminEntity.getEmpStatus());
		salesAdminDTO.setComissionAmount(salesAdminEntity.getComissionAmount());
		salesAdminDTO.setComissionPercent(salesAdminEntity.getComissionPercent());
		salesAdminDTO.setReferralAccountStatus(salesAdminEntity.getReferralAccountStatus());
		salesAdminDTO.setRole(salesAdminEntity.getRole());

		salesAdminDTO.setActive(salesAdminEntity.getisActive());

		salesAdminDTO.setCreatedBy(salesAdminEntity.getCreatedBy());
		salesAdminDTO.setCreatedDate(salesAdminEntity.getCreatedDate());
		salesAdminDTO.setModifiedBy(salesAdminEntity.getModifiedBy());
		salesAdminDTO.setModifiedDate(salesAdminEntity.getModifiedDate());
		salesAdminDTO.setVersion(salesAdminEntity.getVersion());
//		salesAdminDTO.setFlexField1(salesAdminEntity.getFlexField1());
//		salesAdminDTO.setFlexField2(salesAdminEntity.getFlexField2());
//		salesAdminDTO.setFlexField3(salesAdminEntity.getFlexField3());

		return salesAdminDTO;
	}
	public SalesAdmin updateSalesAdminFromDTO(SalesAdmin existingSalesAdmin, SalesAdminDTO salesAdminDTO) {
		// Update the fields of the existing SalesAdmin entity with the values from the
		// DTO
		if(salesAdminDTO.getName()!=null) {
		existingSalesAdmin.setName(salesAdminDTO.getName());
		}
		if(salesAdminDTO.getUsername()!=null) {
		existingSalesAdmin.setUsername(salesAdminDTO.getUsername());
		}
		if(salesAdminDTO.getPassword()!=null) {
		existingSalesAdmin.setPassword(salesAdminDTO.getPassword());
		}
		if(salesAdminDTO.getMobile()!=null) {
		existingSalesAdmin.setMobile(salesAdminDTO.getMobile());
		}
		if(salesAdminDTO.getEmail()!=null) {
		existingSalesAdmin.setEmail(salesAdminDTO.getEmail());
		}
		if(salesAdminDTO.getDob()!=null) {
		existingSalesAdmin.setDob(salesAdminDTO.getDob());
		}
		if(salesAdminDTO.getRefCode()!=null) {
		existingSalesAdmin.setRefCode(salesAdminDTO.getRefCode());
		}
		if(salesAdminDTO.getEmpStatus()!=null) {
		existingSalesAdmin.setEmpStatus(salesAdminDTO.getEmpStatus());
		}
		if(salesAdminDTO.getComissionAmount()!=null) {
		existingSalesAdmin.setComissionAmount(salesAdminDTO.getComissionAmount());
		}
		if(salesAdminDTO.getComissionPercent()!=null) {
		existingSalesAdmin.setComissionPercent(salesAdminDTO.getComissionPercent());
		}
		if(salesAdminDTO.getReferralAccountStatus()!=null) {
		existingSalesAdmin.setReferralAccountStatus(salesAdminDTO.getReferralAccountStatus());
		}
		if(salesAdminDTO.getRole()!=null) {
		existingSalesAdmin.setRole(salesAdminDTO.getRole());
		}
		
		existingSalesAdmin.setActive(salesAdminDTO.getisActive());
		
		if(salesAdminDTO.getCreatedBy()!=null) {
		existingSalesAdmin.setCreatedBy(salesAdminDTO.getCreatedBy());
		}
		if(salesAdminDTO.getCreatedDate()!=null) {
		existingSalesAdmin.setCreatedDate(salesAdminDTO.getCreatedDate());
		}
		if(salesAdminDTO.getModifiedBy()!=null) {
		existingSalesAdmin.setModifiedBy(salesAdminDTO.getModifiedBy());
		}
		if(salesAdminDTO.getModifiedDate()!=null) {
		existingSalesAdmin.setModifiedDate(salesAdminDTO.getModifiedDate());
		}
		if(salesAdminDTO.getVersion()!=null) {
		existingSalesAdmin.setVersion(salesAdminDTO.getVersion());
		}
//		existingSalesAdmin.setFlexField1(salesAdminDTO.getFlexField1());
//		existingSalesAdmin.setFlexField2(salesAdminDTO.getFlexField2());
//		existingSalesAdmin.setFlexField3(salesAdminDTO.getFlexField3());
		return existingSalesAdmin;
	}
 

}
