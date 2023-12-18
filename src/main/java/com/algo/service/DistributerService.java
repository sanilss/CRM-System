package com.algo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.algo.assembler.DistributerAssembler;
import com.algo.config.DistributerIdGenerator;
import com.algo.dto.DistributerDTO;
import com.algo.entity.Distributer;

import com.algo.repository.DistributerRepository;
import com.algo.repository.MasterDistributerRepository;
import com.algo.repository.SalesAdminRepository;

@Service
public class DistributerService {
	DistributerAssembler distributerAssembler = new DistributerAssembler();
	private final DistributerRepository distRepo;
	private final BCryptPasswordEncoder byBCryptPasswordEncoder;
	private final    SalesAdminRepository salesAdminRepo;
	private final MasterDistributerRepository masterDistributerRepo;

	public DistributerService(DistributerRepository distRepo, BCryptPasswordEncoder byBCryptPasswordEncoder,SalesAdminRepository salesAdminRepo,MasterDistributerRepository masterDistributerRepo) {
		this.distRepo = distRepo;
		this.byBCryptPasswordEncoder = byBCryptPasswordEncoder;
		this.salesAdminRepo=salesAdminRepo;
		this.masterDistributerRepo=masterDistributerRepo;
		}

	 public DistributerDTO getDistributer(String distributerId) {
	        try {
	            DistributerIdGenerator.setTableName("distributer");
	            Optional<Distributer> optionalDistributer = distRepo.findById(distributerId);

	            if (optionalDistributer.isPresent()) {
	                Distributer distributer = optionalDistributer.get();
	                
	                // Check if the Distributer is active
	                if (distributer.getisActive()) {
	                    return distributerAssembler.fromDistributer(distributer);
	                } else {
	                    // Distributer is deactivated, you can throw an exception or return null
	                    // depending on your preference
	                    throw new RuntimeException("Distributor with ID " + distributerId + " is deactivated");
	                }
	            } else {
	                // Distributer not found
	                return null;
	            }
	        } catch (NoSuchElementException e) {
	            return null;
	        }
	    }
	// deactivate

	public String deactivateDistributer(String distributerId) {
		try {
			DistributerIdGenerator.setTableName("distributer");
			Optional<Distributer> optionalDistributer = distRepo.findById(distributerId);

			if (optionalDistributer.isPresent()) {
				// Now you have the found distributor, and you can update or deactivate it as
				// needed.
				Distributer distributer = optionalDistributer.get();
				distributer.setActive(false); // Deactivate the distributor

				distRepo.save(distributer);
				return "Distributor deactivated successfully";
			} else {
				return "Distributor with ID " + distributerId + " not found";
			}
		} catch (Exception e) {
			// Log the exception or handle it as needed
			e.printStackTrace();
			return "Failed to deactivate distributor. Please check the input and try again.";
		}
	}

	// create
	public String addDistributer(DistributerDTO distributerDTO) {
		try {
			DistributerIdGenerator.setTableName("distributer");
			// Store the password which would of stringType.
			String encryptedPassword = byBCryptPasswordEncoder.encode(distributerDTO.getPassword());
			// now we want our encrypted password to replace the plainText password.
			distributerDTO.setPassword(encryptedPassword);

			// Save the distributorDTO entity to the repository

			distRepo.save(distributerAssembler.toDistributer(distributerDTO));
			return "Distributor added successfully";
		} catch (Exception e) {
			// Log the exception or handle it as needed
			e.printStackTrace();
			return "Failed to add distributor. Please check the input and try again.";
		}
	}

	public String updateDistributer(String distributerId, DistributerDTO distributerDTO) {
	    try {
	        DistributerIdGenerator.setTableName("distributer");

	        // Retrieve the existing Distributer entity from the database
	        System.out.println("DistributerId:" + distributerId);
	        Optional<Distributer> existingDistributerId = distRepo.findById(distributerId);

	        System.out.println("existingId:" + existingDistributerId);
	        if (existingDistributerId.isPresent()) {
	            Distributer existingDistributer = existingDistributerId.get();
	            System.out.println("existingDistributer:" + existingDistributer);

	            // Validate SALREF if provided
	            String salref = distributerDTO.getSalref();
	            if (salref != null) {
	                boolean isValidSalref = salesAdminRepo.existsById(salref);
	                if (!isValidSalref) {
	                    System.out.println("Invalid SALREF value: " + salref);
	                    return "Invalid SALREF value";
	                }
	            }

	            // Validate MDREF if provided
	            String mdref = distributerDTO.getMdref();
	            if (mdref != null) {
	                boolean isValidMdref = masterDistributerRepo.existsById(mdref);
	                if (!isValidMdref) {
	                    System.out.println("Invalid MDREF value: " + mdref);
	                    return "Invalid MDREF value";
	                }
	            }

	            System.out.println("Updating Distributer...");

	            if (distributerDTO.getPassword() != null) {
	                String encodedPassword = byBCryptPasswordEncoder.encode(distributerDTO.getPassword());
	                distributerDTO.setPassword(encodedPassword);
	            }

	            // Update the existing Distributer entity with the new data from the DTO
	            existingDistributer = distributerAssembler.updateDistributerFromDTO(existingDistributer, distributerDTO);

	            // Save the updated Distributer entity back to the database
	            distRepo.save(existingDistributer);

	            System.out.println("Update successful!");
	            return "Vendor details have been updated successfully";
	        }

	        System.out.println("Distributor ID not found");
	        return "Distributor ID not found";
	    } catch (Exception e) {
	        // Handle the exception (e.g., log it or return an appropriate error message)
	        System.out.println("An error occurred while updating Distributer details: " + e.getMessage());
	        return "An error occurred while updating Distributer details";
	    }
	}




	// findall
	public List<Distributer> getAllDistributers() {
	    try {
	        DistributerIdGenerator.setTableName("distributer");

	        // Fetch all distributors from the repository
	        List<Distributer> allDistributers = distRepo.findAll();

	        // Filter out inactive distributors
	        List<Distributer> activeDistributers = allDistributers.stream()
	                .filter(Distributer::getisActive)
	                .collect(Collectors.toList());

	        return activeDistributers;
	    } catch (DataAccessException e) {
	        // Log the exception or handle it as needed
	        e.printStackTrace();
	        throw new RuntimeException(
	                "Failed to fetch distributors due to a data access issue. Please try again later.");
	    } catch (Exception e) {
	        // Log the exception or handle it as needed
	        e.printStackTrace();
	        throw new RuntimeException("Failed to fetch distributors. Please try again later.");
	    }
	}

}
