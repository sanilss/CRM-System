package com.algo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.algo.assembler.SalesAdminAssembler;
import com.algo.config.DistributerIdGenerator;
import com.algo.dto.DistributerDTO;
import com.algo.dto.SalesAdminDTO;
import com.algo.entity.Distributer;
import com.algo.entity.SalesAdmin;
import com.algo.repository.SalesAdminRepository;

@Service
public class SalesAdminService {
	SalesAdminAssembler salesAdminAssembler = new SalesAdminAssembler();
	private final SalesAdminRepository salesAdminRepo;
	private final BCryptPasswordEncoder byBCryptPasswordEncoder;

	public SalesAdminService(SalesAdminRepository salesAdminRepo, BCryptPasswordEncoder byBCryptPasswordEncoder) {
		this.salesAdminRepo = salesAdminRepo;
		this.byBCryptPasswordEncoder = byBCryptPasswordEncoder;
	}

	//find
	public SalesAdminDTO getSalesAdmin(String salesAdminId) {
	    try {
	        DistributerIdGenerator.setTableName("sales_admin");
	        Optional<SalesAdmin> optionalSalesAdmin = salesAdminRepo.findById(salesAdminId);

	        if (optionalSalesAdmin.isPresent()) {
	            SalesAdmin salesAdmin = optionalSalesAdmin.get();

	            // Check if the SalesAdmin is active
	            if (salesAdmin.getisActive()) {
	                return salesAdminAssembler.fromSalesAdmin(salesAdmin);
	            } else {
	                // SalesAdmin is deactivated, you can throw an exception or return null
	                // depending on your preference
	                throw new RuntimeException("SalesAdmin with ID " + salesAdminId + " is deactivated");
	            }
	        } else {
	            // SalesAdmin not found
	            return null;
	        }
	    } catch (Exception e) {
	      
	        return null;
	    }
	}


	// findall
	public List<SalesAdmin> getAllSalesAdmins() {
	    try {
	        DistributerIdGenerator.setTableName("sales_admin");

	        // Fetch all sales admins from the repository
	        List<SalesAdmin> allSalesAdmins = salesAdminRepo.findAll();

	        // Filter out inactive sales admins
	        List<SalesAdmin> activeSalesAdmins = allSalesAdmins.stream()
	                .filter(SalesAdmin::getisActive)
	                .collect(Collectors.toList());

	        return activeSalesAdmins;
	    } catch (DataAccessException e) {
	        // Log the exception or handle it as needed
	        e.printStackTrace();
	        throw new RuntimeException(
	                "Failed to fetch SalesAdmins due to a data access issue. Please try again later.");
	    } catch (Exception e) {
	        // Log the exception or handle it as needed
	        e.printStackTrace();
	        throw new RuntimeException("Failed to fetch SalesAdmins. Please try again later.");
	    }
	}


	// create
	public String addSalesAdmin(SalesAdminDTO salesAdminDTO) {
		try {
			DistributerIdGenerator.setTableName("sales_admin");
			// Store the password which would of stringType.
			String encryptedPassword = byBCryptPasswordEncoder.encode(salesAdminDTO.getPassword());
			// now we want our encrypted password to replace the plainText password.
			salesAdminDTO.setPassword(encryptedPassword);

			// Save the distributorDTO entity to the repository
			salesAdminRepo.save(salesAdminAssembler.toSalesAdmin(salesAdminDTO));
			return "Sales Admin Added SuccessFully";
		} catch (Exception e) {
			// Log the exception or handle it as needed
			e.printStackTrace();
			return "Failed to add SalesAdmin. Please check the input and try again.";
		}
	}

	// update
	public String updateSalesAdmin(String salesAdminId, SalesAdminDTO salesAdminDTO) {
		try {
			DistributerIdGenerator.setTableName("sales_admin");
			// Retrieve the existing Distributer entity from the database
			Optional<SalesAdmin> existingSalesAdminId = salesAdminRepo.findById(salesAdminId);

			if (existingSalesAdminId.isPresent()) {
				SalesAdmin existingSalesAdmin = existingSalesAdminId.get();
				if (salesAdminDTO.getPassword() != null) {
					String encodedPassword = byBCryptPasswordEncoder.encode(salesAdminDTO.getPassword());
					salesAdminDTO.setPassword(encodedPassword);
				}
				// Update the existing Distributer entity with the new data from the DTO
				existingSalesAdmin = salesAdminAssembler.updateSalesAdminFromDTO(existingSalesAdmin, salesAdminDTO);

				// Save the updated Distributer entity back to the database
				salesAdminRepo.save(existingSalesAdmin);
				return "Vendor details have been updated SuccessFully";
			}
			return "SalesAdminController ID not found";
		} catch (Exception e) {
			// Handle the exception (e.g., log it or return an appropriate error message)
			return "An error occurred while updating SalesAdmin details";
		}
	}
	
	// deactivate

		public String deactivateSalesAdmin(String salesAdminId) {
			try {
				DistributerIdGenerator.setTableName("sales_admin");
				Optional<SalesAdmin> optionalSalesAdmin = salesAdminRepo.findById(salesAdminId);

				if (optionalSalesAdmin.isPresent()) {
					// Now you have the found distributor, and you can update or deactivate it as
					// needed.
					SalesAdmin salesAdmin = optionalSalesAdmin.get();
					salesAdmin.setActive(false); // Deactivate the distributor

					salesAdminRepo.save(salesAdmin);
					return "SalesAdmin deactivated successfully";
				} else {
					return "SalesAdmin with ID " + salesAdminId + " not found";
				}
			} catch (Exception e) {
				// Log the exception or handle it as needed
				e.printStackTrace();
				return "Failed to deactivate SalesAdmin. Please check the input and try again.";
			}
		}


}
