package com.algo.assembler;


	import com.algo.dto.MasterDistributerDTO;
	import com.algo.entity.MasterDistributer;

	public class MasterDistributerAssembler {

		private MasterDistributer masterDistributerEntity;
		private MasterDistributerDTO masterDistributerDTO;

		public MasterDistributer toMasterDistributer(MasterDistributerDTO masterDistributerDTO) {
			masterDistributerEntity = new MasterDistributer();
			masterDistributerEntity.setId(masterDistributerDTO.getId());
			masterDistributerEntity.setName(masterDistributerDTO.getName());
			masterDistributerEntity.setUsername(masterDistributerDTO.getUsername());
			masterDistributerEntity.setPassword(masterDistributerDTO.getPassword());
			masterDistributerEntity.setMobile(masterDistributerDTO.getMobile());
			masterDistributerEntity.setEmail(masterDistributerDTO.getEmail());
			masterDistributerEntity.setDob(masterDistributerDTO.getDob());
			masterDistributerEntity.setRefCode(masterDistributerDTO.getRefCode());
			masterDistributerEntity.setEmpStatus(masterDistributerDTO.getEmpStatus());
			masterDistributerEntity.setComissionAmount(masterDistributerDTO.getComissionAmount());
			masterDistributerEntity.setComissionPercent(masterDistributerDTO.getComissionPercent());
			masterDistributerEntity.setReferralAccountStatus(masterDistributerDTO.getReferralAccountStatus());
			masterDistributerEntity.setRole(masterDistributerDTO.getRole());
			masterDistributerEntity.setSalref(masterDistributerDTO.getSalref());
			masterDistributerEntity.setActive(masterDistributerDTO.getisActive());

			masterDistributerEntity.setCreatedBy(masterDistributerDTO.getCreatedBy());
			masterDistributerEntity.setCreatedDate(masterDistributerDTO.getCreatedDate());
			masterDistributerEntity.setModifiedBy(masterDistributerDTO.getModifiedBy());
			masterDistributerEntity.setModifiedDate(masterDistributerDTO.getModifiedDate());
			masterDistributerEntity.setVersion(masterDistributerDTO.getVersion());

//			masterDistributerEntity.setFlexField1(masterDistributerDTO.getFlexField1());
//			masterDistributerEntity.setFlexField2(masterDistributerDTO.getFlexField2());
//			masterDistributerEntity.setFlexField3(masterDistributerDTO.getFlexField3());
			return masterDistributerEntity;
		}

		public MasterDistributerDTO fromMasterDistributer(MasterDistributer masterDistributerEntity) {
			//
			masterDistributerDTO = new MasterDistributerDTO();

			masterDistributerDTO.setId(masterDistributerEntity.getId());
			masterDistributerDTO.setName(masterDistributerEntity.getName());
			masterDistributerDTO.setUsername(masterDistributerEntity.getUsername());
			masterDistributerDTO.setPassword(masterDistributerEntity.getPassword());
			masterDistributerDTO.setMobile(masterDistributerEntity.getMobile());
			masterDistributerDTO.setEmail(masterDistributerEntity.getEmail());
			masterDistributerDTO.setDob(masterDistributerEntity.getDob());
			masterDistributerDTO.setRefCode(masterDistributerEntity.getRefCode());
			masterDistributerDTO.setEmpStatus(masterDistributerEntity.getEmpStatus());
			masterDistributerDTO.setComissionAmount(masterDistributerEntity.getComissionAmount());
			masterDistributerDTO.setComissionPercent(masterDistributerEntity.getComissionPercent());
			masterDistributerDTO.setReferralAccountStatus(masterDistributerEntity.getReferralAccountStatus());
			masterDistributerDTO.setRole(masterDistributerEntity.getRole());
			masterDistributerDTO.setSalref(masterDistributerEntity.getSalref());
			masterDistributerDTO.setActive(masterDistributerEntity.getisActive());

			masterDistributerDTO.setCreatedBy(masterDistributerEntity.getCreatedBy());
			masterDistributerDTO.setCreatedDate(masterDistributerEntity.getCreatedDate());
			masterDistributerDTO.setModifiedBy(masterDistributerEntity.getModifiedBy());
			masterDistributerDTO.setModifiedDate(masterDistributerEntity.getModifiedDate());
			masterDistributerDTO.setVersion(masterDistributerEntity.getVersion());
//			masterDistributerDTO.setFlexField1(masterDistributerEntity.getFlexField1());
//			masterDistributerDTO.setFlexField2(masterDistributerEntity.getFlexField2());
//			masterDistributerDTO.setFlexField3(masterDistributerEntity.getFlexField3());

			return masterDistributerDTO;
		}

		public MasterDistributer updateMasterDistributerFromDTO(MasterDistributer existingMasterDistributer, MasterDistributerDTO masterDistributerDTO) {
			// Update the fields of the existing Distributer entity with the values from the
			// DTO
			if(masterDistributerDTO.getName()!=null) {
			existingMasterDistributer.setName(masterDistributerDTO.getName());
			}
			if(masterDistributerDTO.getUsername()!=null) {
			existingMasterDistributer.setUsername(masterDistributerDTO.getUsername());
			}
			if(masterDistributerDTO.getPassword()!=null) {
			existingMasterDistributer.setPassword(masterDistributerDTO.getPassword());
			}
			if(masterDistributerDTO.getMobile()!=null) {
			existingMasterDistributer.setMobile(masterDistributerDTO.getMobile());
			}
			if(masterDistributerDTO.getEmail()!=null) {
			existingMasterDistributer.setEmail(masterDistributerDTO.getEmail());
			}
			if(masterDistributerDTO.getDob()!=null) {
			existingMasterDistributer.setDob(masterDistributerDTO.getDob());
			}
			if(masterDistributerDTO.getRefCode()!=null) {
			existingMasterDistributer.setRefCode(masterDistributerDTO.getRefCode());
			}
			if(masterDistributerDTO.getEmpStatus()!=null) {
			existingMasterDistributer.setEmpStatus(masterDistributerDTO.getEmpStatus());
			}
			if(masterDistributerDTO.getComissionAmount()!=null) {
			existingMasterDistributer.setComissionAmount(masterDistributerDTO.getComissionAmount());
			}
			if(masterDistributerDTO.getComissionPercent()!=null) {
			existingMasterDistributer.setComissionPercent(masterDistributerDTO.getComissionPercent());
			}
			if(masterDistributerDTO.getReferralAccountStatus()!=null) {
			existingMasterDistributer.setReferralAccountStatus(masterDistributerDTO.getReferralAccountStatus());
			}
			if(masterDistributerDTO.getRole()!=null) {
			existingMasterDistributer.setRole(masterDistributerDTO.getRole());
			}
			if(masterDistributerDTO.getSalref()!=null) {
			existingMasterDistributer.setSalref(masterDistributerDTO.getSalref());
			}
		
			existingMasterDistributer.setActive(masterDistributerDTO.getisActive());
			
			if(masterDistributerDTO.getCreatedBy()!=null) {
			existingMasterDistributer.setCreatedBy(masterDistributerDTO.getCreatedBy());
			}
			if(masterDistributerDTO.getCreatedDate()!=null) {
			existingMasterDistributer.setCreatedDate(masterDistributerDTO.getCreatedDate());
			}
			if(masterDistributerDTO.getModifiedBy()!=null) {
			existingMasterDistributer.setModifiedBy(masterDistributerDTO.getModifiedBy());
			}
			if(masterDistributerDTO.getModifiedDate()!=null) {
			existingMasterDistributer.setModifiedDate(masterDistributerDTO.getModifiedDate());
			}
			if(masterDistributerDTO.getVersion()!=null) {
			existingMasterDistributer.setVersion(masterDistributerDTO.getVersion());
			}
//			existingMasterDistributer.setFlexField1(masterDistributerDTO.getFlexField1());
//			existingMasterDistributer.setFlexField2(masterDistributerDTO.getFlexField2());
//			existingMasterDistributer.setFlexField3(masterDistributerDTO.getFlexField3());
			return existingMasterDistributer;
		}

	}
