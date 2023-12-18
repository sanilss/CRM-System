package com.algo.service;

import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import com.algo.assembler.MasterDistributerAssembler;
import com.algo.config.DistributerIdGenerator;
import com.algo.dto.DistributerDTO;
import com.algo.dto.MasterDistributerDTO;
import com.algo.entity.Distributer;
import com.algo.entity.MasterDistributer;
import com.algo.repository.MasterDistributerRepository;
import com.algo.repository.SalesAdminRepository;

@Service
public class MasterDistributerService {

	MasterDistributerAssembler masterDistributerAssembler = new MasterDistributerAssembler();
	private final MasterDistributerRepository masterDistRepo;
	private final BCryptPasswordEncoder byBCryptPasswordEncoder;
	private final SalesAdminRepository salesAdminRepo;

	public MasterDistributerService(MasterDistributerRepository masterDistRepo,BCryptPasswordEncoder byBCryptPasswordEncoder,SalesAdminRepository salesAdminRepo) {

		this.masterDistRepo = masterDistRepo;
		this.byBCryptPasswordEncoder = byBCryptPasswordEncoder;
		this.salesAdminRepo=salesAdminRepo;
		}
//find
	public MasterDistributerDTO getMasterDistributer(String masterDistributerId) {
        try {
            // Set the table name before adding the master distributor
            DistributerIdGenerator.setTableName("master_distributer");

            Optional<MasterDistributer> optionalMasterDistributer = masterDistRepo.findById(masterDistributerId);

            if (optionalMasterDistributer.isPresent()) {
                MasterDistributer masterDistributer = optionalMasterDistributer.get();

                // Check if the MasterDistributer is active
                if (masterDistributer.getisActive()) {
                    return masterDistributerAssembler.fromMasterDistributer(masterDistributer);
                } else {
                    // MasterDistributer is deactivated, you can throw an exception or return null
                    // depending on your preference
                    throw new RuntimeException("MasterDistributor with ID " + masterDistributerId + " is deactivated");
                }
            } else {
                // MasterDistributer not found
                return null;
            }
        } catch (NoSuchElementException e) {
            return null;
        }
    }

//deactivate
	public String deactivateMasterDistributer(String masterDistributerId) {

		try {
			DistributerIdGenerator.setTableName("master_distributer");
			Optional<MasterDistributer> optionalMasterDistributer = masterDistRepo.findById(masterDistributerId);
			if (optionalMasterDistributer.isPresent()) {
				// Now you have the found masterdistributor, and you deactivate it as needed.
				MasterDistributer masterDistributer = optionalMasterDistributer.get();
				masterDistributer.setActive(false); // Deactivate the distributor
				masterDistRepo.save(masterDistributer);
				return "Master Distributer deactivated Successfully";
			} else {

				return "MasterDistributer with ID" + masterDistributerId + "not found";

			}

		} catch (Exception e) {
			// Log the exception or handle it as needed
			e.printStackTrace();
			return "Failed to deactivate Masterdistributor. Please check the input and try again.";
		}
	}

	// create
	public String addMasterDistributer(MasterDistributerDTO masterDistributerDTO) {
		try {

			 // Set the table name before adding the master distributor
	        DistributerIdGenerator.setTableName("master_distributer");
			// Store the password which would of stringType.
			String encryptedPassword = byBCryptPasswordEncoder.encode(masterDistributerDTO.getPassword());
			// now we want our encrypted password to replace the plainText password.
			masterDistributerDTO.setPassword(encryptedPassword);

			masterDistRepo.save(masterDistributerAssembler.toMasterDistributer(masterDistributerDTO));
			return "MasterDistributer added Successfully";

		} catch (Exception e) {
			// Log the exception or handle it as needed
			e.printStackTrace();
			return "Failed to add MasterDistributer. Please check the input and try again.";
		}finally {
	        // Ensure that the ThreadLocal is cleared, even in case of an exception
	        DistributerIdGenerator.clearTableName();
	    }

	}

	// update
	public String updateMasterDistributer(String masterDistributerId, MasterDistributerDTO masterDistributerDTO) {
	    try {
	        DistributerIdGenerator.setTableName("master_distributer");

	        // Retrieve the existing Distributer entity from the database
	       
	        Optional<MasterDistributer> existingMasterDistributerId = masterDistRepo.findById(masterDistributerId);

	        System.out.println("existingMasterId:" + existingMasterDistributerId);
	        if (existingMasterDistributerId.isPresent()) {
	            MasterDistributer existingMasterDistributer = existingMasterDistributerId.get();
	            System.out.println("existingDistributer:" + existingMasterDistributer);

	            // Validate SALREF if provided
	            String salref = masterDistributerDTO.getSalref();
	            if (salref != null) {
	                boolean isValidSalref = salesAdminRepo.existsById(salref);
	                if (!isValidSalref) {
	                    System.out.println("Invalid SALREF value: " + salref);
	                    return "Invalid SALREF value";
	                }
	            }	
	            System.out.println("Updating Distributer...");

	            if (masterDistributerDTO.getPassword() != null) {
	                String encodedPassword = byBCryptPasswordEncoder.encode(masterDistributerDTO.getPassword());
	                masterDistributerDTO.setPassword(encodedPassword);
	            }

	            // Update the existing Distributer entity with the new data from the DTO
	            existingMasterDistributer = masterDistributerAssembler.updateMasterDistributerFromDTO(existingMasterDistributer, masterDistributerDTO);

	            // Save the updated Distributer entity back to the database
	            masterDistRepo.save(existingMasterDistributer);

	            System.out.println("Update successful!");
	            return "Vendor details have been updated successfully";
	        }

	        System.out.println("MasterDistributor ID not found");
	        return "MasterDistributor ID not found";
	    } catch (Exception e) {
	        // Handle the exception (e.g., log it or return an appropriate error message)
	        System.out.println("An error occurred while updating MasterDistributer details: " + e.getMessage());
	        return "An error occurred while updating MasterDistributer details";
	    }
	}


	// findall
	public List<MasterDistributer> getAllMasterDistributers() {
	    try {
	        DistributerIdGenerator.setTableName("master_distributer");

	        // Fetch all master distributors from the repository
	        List<MasterDistributer> allMasterDistributers = masterDistRepo.findAll();

	        // Filter out inactive master distributors
	        List<MasterDistributer> activeMasterDistributers = allMasterDistributers.stream()
	                .filter(MasterDistributer::getisActive)
	                .collect(Collectors.toList());

	        return activeMasterDistributers;
	    } catch (DataAccessException e) {
	        // Log the exception or handle it as needed
	        e.printStackTrace();
	        throw new RuntimeException(
	                "Failed to fetch Masterdistributors due to a data access issue. Please try again later.");
	    } catch (Exception e) {
	        // Log the exception or handle it as needed
	        e.printStackTrace();
	        throw new RuntimeException("Failed to fetch Masterdistributors. Please try again later.");
	    }
	}

}
