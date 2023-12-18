package com.algo.assembler;

import com.algo.dto.MasterAdminDTO;
import com.algo.entity.MasterAdmin;

public class MasterAdminAssembler {

	public MasterAdminDTO masterAdminDTO;
	public MasterAdmin masterAdminEntity;

	public MasterAdmin toMasterAdmin(MasterAdminDTO masterAdminDTO) {
		masterAdminEntity = new MasterAdmin();
		masterAdminEntity.setId(masterAdminDTO.getId());
		masterAdminEntity.setName(masterAdminDTO.getName());
		masterAdminEntity.setPassword(masterAdminDTO.getPassword());
		masterAdminEntity.setRole(masterAdminDTO.getRole());
		masterAdminEntity.setisActive(masterAdminDTO.getisActive());

		return masterAdminEntity;
	}

	public MasterAdminDTO fromMasterAdmin(MasterAdmin masterAdminEntity) {
		masterAdminDTO = new MasterAdminDTO();
		masterAdminDTO.setId(masterAdminEntity.getId());
		masterAdminDTO.setName(masterAdminEntity.getName());
		masterAdminDTO.setPassword(masterAdminEntity.getPassword());
		masterAdminDTO.setRole(masterAdminEntity.getRole());
		masterAdminDTO.setActive(masterAdminEntity.getisActive());

		return masterAdminDTO;
	}

	public MasterAdmin updateMasterAdminFromDTO(MasterAdmin existingMasterAdmin, MasterAdminDTO masterAdminDTO) {
		if(masterAdminDTO.getName()!=null) {
		existingMasterAdmin.setName(masterAdminDTO.getName());
		}
		if(masterAdminDTO.getPassword()!=null) {
		existingMasterAdmin.setPassword(masterAdminDTO.getPassword());
		}
		if(masterAdminDTO.getRole()!=null) {
		existingMasterAdmin.setRole(masterAdminDTO.getRole());
		}
		
		existingMasterAdmin.setisActive(masterAdminDTO.getisActive());
		
		return existingMasterAdmin;
	}
}
