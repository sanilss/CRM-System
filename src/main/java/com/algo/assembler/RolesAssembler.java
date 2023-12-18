package com.algo.assembler;

import com.algo.dto.RolesDTO;
import com.algo.entity.Roles;

public class RolesAssembler {

		private Roles rolesEntity;
		private RolesDTO rolesDTO;

		public Roles toRoles(RolesDTO rolesDTO) {
			rolesEntity = new Roles();
			rolesEntity.setId(rolesDTO.getId());
			rolesEntity.setRoleName(rolesDTO.getRoleName());
			rolesEntity.setRoleType(rolesDTO.getRoleType());
			rolesEntity.setPermission(rolesDTO.getPermission());
			return rolesEntity;
		}

		public RolesDTO fromRoles(Roles rolesEntity) {
			rolesDTO = new RolesDTO();
			rolesDTO.setId(rolesEntity.getId());
			rolesDTO.setRoleName(rolesEntity.getRoleName());
			rolesDTO.setRoleType(rolesEntity.getRoleType());
			rolesDTO.setPermission(rolesEntity.getPermission());
			return rolesDTO;
		}

		public Roles updateRolesFromDTO(Roles rolesEntity, RolesDTO rolesDTO) {
			if(rolesDTO.getRoleName()!=null) {
			rolesEntity.setRoleName(rolesDTO.getRoleName());
			}
			if(rolesDTO.getRoleType()!=null) {
			rolesEntity.setRoleType(rolesDTO.getRoleType());
			}
			if(rolesDTO.getPermission()!=null) {
			rolesEntity.setPermission(rolesDTO.getPermission());
			}
			return rolesEntity;
		}

}
