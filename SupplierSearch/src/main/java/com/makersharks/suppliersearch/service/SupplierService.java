package com.makersharks.suppliersearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.makersharks.suppliersearch.model.Supplier;
import com.makersharks.suppliersearch.repository.SupplierRepository;

@Service
public class SupplierService {
    
	@Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getSuppliers(String location, String natureOfBusiness, String manufacturingProcesses) {
    	return supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcesses(
                location, natureOfBusiness, manufacturingProcesses);
    }
    
 // Update the service method
    public List<Supplier> searchSuppliers(String location, String natureOfBusiness, String manufacturingProcesses, int page, int size) {
        // Calculate start and end row numbers for pagination
        int start = page * size + 1;
        int end = start + size - 1;

        // Call the repository method
        return supplierRepository.findSuppliersWithPagination(location, natureOfBusiness, manufacturingProcesses, start, end);
    }
}

