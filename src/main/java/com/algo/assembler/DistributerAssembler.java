package com.algo.assembler;

import com.algo.dto.DistributerDTO;
import com.algo.entity.Distributer;

public class DistributerAssembler {

	private Distributer distributerEntity;
	private DistributerDTO distributerDTO;

	public Distributer toDistributer(DistributerDTO distributerDTO) {
		distributerEntity = new Distributer();
		distributerEntity.setId(distributerDTO.getId());
		distributerEntity.setName(distributerDTO.getName());
		distributerEntity.setUsername(distributerDTO.getUsername());
		distributerEntity.setPassword(distributerDTO.getPassword());
		distributerEntity.setMobile(distributerDTO.getMobile());
		distributerEntity.setEmail(distributerDTO.getEmail());
		distributerEntity.setDob(distributerDTO.getDob());
		distributerEntity.setRefCode(distributerDTO.getRefCode());
		distributerEntity.setEmpStatus(distributerDTO.getEmpStatus());
		distributerEntity.setComissionAmount(distributerDTO.getComissionAmount());
		distributerEntity.setComissionPercent(distributerDTO.getComissionPercent());
		distributerEntity.setReferralAccountStatus(distributerDTO.getReferralAccountStatus());
		distributerEntity.setRole(distributerDTO.getRole());
		distributerEntity.setMdref(distributerDTO.getMdref());
		distributerEntity.setSalref(distributerDTO.getSalref());
		distributerEntity.setActive(distributerDTO.getisActive());

		distributerEntity.setCreatedBy(distributerDTO.getCreatedBy());
		distributerEntity.setCreatedDate(distributerDTO.getCreatedDate());
		distributerEntity.setModifiedBy(distributerDTO.getModifiedBy());
		distributerEntity.setModifiedDate(distributerDTO.getModifiedDate());
		distributerEntity.setVersion(distributerDTO.getVersion());

		return distributerEntity;
	}

	public DistributerDTO fromDistributer(Distributer distributerEntity) {
		
		distributerDTO = new DistributerDTO();

		distributerDTO.setId(distributerEntity.getId());
		distributerDTO.setName(distributerEntity.getName());
		distributerDTO.setUsername(distributerEntity.getUsername());
		distributerDTO.setPassword(distributerEntity.getPassword());
		distributerDTO.setMobile(distributerEntity.getMobile());
		distributerDTO.setEmail(distributerEntity.getEmail());
		distributerDTO.setDob(distributerEntity.getDob());
		distributerDTO.setRefCode(distributerEntity.getRefCode());
		distributerDTO.setEmpStatus(distributerEntity.getEmpStatus());
		distributerDTO.setComissionAmount(distributerEntity.getComissionAmount());
		distributerDTO.setComissionPercent(distributerEntity.getComissionPercent());
		distributerDTO.setReferralAccountStatus(distributerEntity.getReferralAccountStatus());
		distributerDTO.setRole(distributerEntity.getRole());
		distributerDTO.setMdref(distributerEntity.getMdref());
		distributerDTO.setSalref(distributerEntity.getSalref());
		distributerDTO.setActive(distributerEntity.getisActive());

		distributerDTO.setCreatedBy(distributerEntity.getCreatedBy());
		distributerDTO.setCreatedDate(distributerEntity.getCreatedDate());
		distributerDTO.setModifiedBy(distributerEntity.getModifiedBy());
		distributerDTO.setModifiedDate(distributerEntity.getModifiedDate());
		distributerDTO.setVersion(distributerEntity.getVersion());

		return distributerDTO;
	}

	public Distributer updateDistributerFromDTO(Distributer existingDistributer, DistributerDTO distributerDTO) {
		// Update the fields of the existing Distributer entity with the values from the
		// DTO
		if (distributerDTO.getName() != null) {
			existingDistributer.setName(distributerDTO.getName());
		}
		if (distributerDTO.getUsername() != null) {
			existingDistributer.setUsername(distributerDTO.getUsername());
		}
		if (distributerDTO.getPassword() != null) {
			existingDistributer.setPassword(distributerDTO.getPassword());
		}

		if (distributerDTO.getMobile() != null) {
			existingDistributer.setMobile(distributerDTO.getMobile());
		}
		if (distributerDTO.getEmail() != null) {
			existingDistributer.setEmail(distributerDTO.getEmail());

		}

		if (distributerDTO.getDob() != null) {
			existingDistributer.setDob(distributerDTO.getDob());
		}

		if (distributerDTO.getRefCode() != null) {
			existingDistributer.setRefCode(distributerDTO.getRefCode());
		}

		if (distributerDTO.getEmpStatus() != null) {
			existingDistributer.setEmpStatus(distributerDTO.getEmpStatus());
		}
		if (distributerDTO.getComissionAmount() != null) {
			existingDistributer.setComissionAmount(distributerDTO.getComissionAmount());
		}

		if (distributerDTO.getComissionPercent() != null) {
			existingDistributer.setComissionPercent(distributerDTO.getComissionPercent());
		}
		if (distributerDTO.getReferralAccountStatus() != null) {
			existingDistributer.setReferralAccountStatus(distributerDTO.getReferralAccountStatus());
		}
		if (distributerDTO.getRole() != null) {
			existingDistributer.setRole(distributerDTO.getRole());
		}
		if (distributerDTO.getMdref() != null) {
			existingDistributer.setMdref(distributerDTO.getMdref());
		}
		if (distributerDTO.getSalref() != null) {
			existingDistributer.setSalref(distributerDTO.getSalref());
		}

		existingDistributer.setActive(distributerDTO.getisActive());
		
		if (distributerDTO.getCreatedBy() != null) {
			existingDistributer.setCreatedBy(distributerDTO.getCreatedBy());
		}
		
		if(distributerDTO.getCreatedDate() != null) {
		existingDistributer.setCreatedDate(distributerDTO.getCreatedDate());
		}
		if(distributerDTO.getModifiedBy() != null) {
		existingDistributer.setModifiedBy(distributerDTO.getModifiedBy());
		}
		
		if(distributerDTO.getModifiedDate()!=null) {
		existingDistributer.setModifiedDate(distributerDTO.getModifiedDate());
		}
		
		if(distributerDTO.getVersion()!=null) {
		existingDistributer.setVersion(distributerDTO.getVersion());
		}
		return existingDistributer;
	}

}
