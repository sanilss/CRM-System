package com.algo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import com.algo.assembler.RolesAssembler;
import com.algo.dto.RolesDTO;
import com.algo.entity.Roles;
import com.algo.repository.RolesRepository;

@Service
public class RolesService {
	RolesAssembler rolesAssembler = new RolesAssembler();
	private final RolesRepository roleRepo;

	public RolesService(RolesRepository roleRepo) {
		this.roleRepo = roleRepo;
	}

	public RolesDTO getRoles(String roleId) {
		try {
			Roles roles = roleRepo.findById(roleId).get();
			RolesDTO rolesDTO = rolesAssembler.fromRoles(roles);
			return rolesDTO;
		} catch (Exception e) {
			throw new RuntimeException("An error occurred while fetching the role.", e);
		}
	}

	public String addRoles(RolesDTO rolesDTO) {
		try {
			Roles roles = rolesAssembler.toRoles(rolesDTO);
			roleRepo.save(roles);
			return "Distributor added successfully";
		} catch (Exception e) {
			throw new RuntimeException("An error occurred while adding the role.", e);
		}
	}

	// update
	public String updateRoles(String id, RolesDTO rolesDTO) {
		try {
			Optional<Roles> existingRolesId = roleRepo.findById(id);
			if (existingRolesId.isPresent()) {
				Roles existingRoles = existingRolesId.get();
				existingRoles = rolesAssembler.updateRolesFromDTO(existingRoles, rolesDTO);
				roleRepo.save(existingRoles);
				return " Data Updated Successfully";
			}
			return "Distributor Data Not Found";
		} catch (Exception e) {
			throw new RuntimeException("An error occurred while adding the role.", e);
		}
	}

	public List<RolesDTO> getAllRoles() {
		try {
			List<Roles> allRoles = roleRepo.findAll();
			List<RolesDTO> allRolesDTO = allRoles.stream().map(rolesAssembler::fromRoles).collect(Collectors.toList());
			return allRolesDTO;
		} catch (Exception e) {
			throw new RuntimeException("An error occurred while fetching all roles.", e);
		}
	}

	public String deleteRoles(String roleId) throws NotFoundException {
		try {
			Roles role = roleRepo.findById(roleId).orElse(null);
			if (role != null) {
				// Perform deletion logic
				roleRepo.delete(role);
				return "Successfully deleted.";
			} else {
				return "Not Deleted";
			}
		} catch (Exception e) {
			throw new RuntimeException("An error occurred while deleting role.", e);
		}
	}

}
