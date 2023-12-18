package com.algo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.algo.assembler.MasterAdminAssembler;
import com.algo.config.DistributerIdGenerator;
import com.algo.dto.MasterAdminDTO;
import com.algo.entity.MasterAdmin;
import com.algo.repository.MasterAdminRepository;

@Service
public class MasterAdminService {
	MasterAdminAssembler masterAdminAssembler = new MasterAdminAssembler();
	private final MasterAdminRepository masterAdminRepo;
	private final BCryptPasswordEncoder byBCryptPasswordEncoder;

	public MasterAdminService(MasterAdminRepository masterAdminRepo, BCryptPasswordEncoder byBCryptPasswordEncoder) {
		this.masterAdminRepo = masterAdminRepo;
		this.byBCryptPasswordEncoder = byBCryptPasswordEncoder;
	}

	public MasterAdminDTO getMasterAdmin(String masterAdminId) {
	    try {
	        DistributerIdGenerator.setTableName("master_admin");
	        Optional<MasterAdmin> optionalMasterAdmin = masterAdminRepo.findById(masterAdminId);

	        if (optionalMasterAdmin.isPresent()) {
	            MasterAdmin masterAdmin = optionalMasterAdmin.get();

	            // Check if the MasterAdmin is active
	            if (masterAdmin.getisActive()) {
	                return masterAdminAssembler.fromMasterAdmin(masterAdmin);
	            } else {
	                // MasterAdmin is deactivated, you can throw an exception or return null
	                // depending on your preference
	                throw new RuntimeException("MasterAdmin with ID " + masterAdminId + " is deactivated");
	            }
	        } else {
	            // MasterAdmin not found
	            return null;
	        }
	    } catch (NoSuchElementException e) {
	        return null;
	    }
	}
	// findall
	public List<MasterAdmin> getAllMasterAdmins() {
	    try {
	        DistributerIdGenerator.setTableName("master_admin");

	        // Fetch all MasterAdmins from the repository
	        List<MasterAdmin> allMasterAdmins = masterAdminRepo.findAll();

	        // Filter out inactive MasterAdmins
	        List<MasterAdmin> activeMasterAdmins = allMasterAdmins.stream()
	                .filter(MasterAdmin::getisActive)
	                .collect(Collectors.toList());

	        return activeMasterAdmins;
	    } catch (DataAccessException e) {
	        // Log the exception or handle it as needed
	        e.printStackTrace();
	        throw new RuntimeException(
	                "Failed to fetch MasterAdmin due to a data access issue. Please try again later.");
	    } catch (Exception e) {
	        // Log the exception or handle it as needed
	        e.printStackTrace();
	        throw new RuntimeException("Failed to fetch masterAdmin. Please try again later.");
	    }
	}
	// create
	public String addMasterAdmin(MasterAdminDTO masterAdminDTO) {
		try {
			DistributerIdGenerator.setTableName("master_admin");
			// Store the password which would of stringType.
			String encryptedPassword = byBCryptPasswordEncoder.encode(masterAdminDTO.getPassword());
			// now we want our encrypted password to replace the plainText password.
			masterAdminDTO.setPassword(encryptedPassword);

			// Save the distributorDTO entity to the repository
			masterAdminRepo.save(masterAdminAssembler.toMasterAdmin(masterAdminDTO));
			return "MasterAdmin added successfully";
		} catch (Exception e) {
			// Log the exception or handle it as needed
			e.printStackTrace();
			return "Failed to add MasterAdmin. Please check the input and try again.";
		}
	}

	// update
	public String updateMasterAdmin(String masterAdminId, MasterAdminDTO masterAdminDTO) {
		try {
			DistributerIdGenerator.setTableName("master_admin");
			// Retrieve the existing Distributer entity from the database
			Optional<MasterAdmin> existingMasterAdminId = masterAdminRepo.findById(masterAdminId);

			if (existingMasterAdminId.isPresent()) {
				MasterAdmin existingMasterAdmin = existingMasterAdminId.get();

				if (masterAdminDTO.getPassword() != null) {

					String encodedPassword = byBCryptPasswordEncoder.encode(masterAdminDTO.getPassword());
					masterAdminDTO.setPassword(encodedPassword);
				}
				// Update the existing MasterAdmin entity with the new data from the DTO
				existingMasterAdmin = masterAdminAssembler.updateMasterAdminFromDTO(existingMasterAdmin,
						masterAdminDTO);

				// Save the updated MasterAdmin entity back to the database
				masterAdminRepo.save(existingMasterAdmin);
				return " MasterAdmin details have been updated SuccessFully";
			}
			return "MasterAdminController ID not found";
		} catch (Exception e) {
			// Handle the exception (e.g., log it or return an appropriate error message)
			return "An error occurred while updating MasterAdmin details";
		}
	}

	// deactivate

	public String deactivateMasterAdmin(String masterAdminId) {
		try {
			DistributerIdGenerator.setTableName("master_admin");
			Optional<MasterAdmin> optionalMasterAdmin = masterAdminRepo.findById(masterAdminId);

			if (optionalMasterAdmin.isPresent()) {
				// Now you have the found distributor, and you can update or deactivate it as
				// needed.
				MasterAdmin masterAdmin = optionalMasterAdmin.get();
				masterAdmin.setisActive(false); // Deactivate the distributor

				masterAdminRepo.save(masterAdmin);
				return "MasterAdmin deactivated successfully";
			} else {
				return "MasterAdmin with ID " + masterAdminId + " not found";
			}
		} catch (Exception e) {
			// Log the exception or handle it as needed
			e.printStackTrace();
			return "Failed to deactivate MasterAdmin. Please check the input and try again.";
		}
	}

}
