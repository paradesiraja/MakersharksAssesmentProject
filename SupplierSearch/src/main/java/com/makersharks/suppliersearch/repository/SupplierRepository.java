package com.makersharks.suppliersearch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.makersharks.suppliersearch.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    
	List<Supplier> findByLocationAndNatureOfBusinessAndManufacturingProcesses(
            String location,
            String natureOfBusiness,
            String manufacturingProcesses);
	
	// Update the repository method
	@Query(value = "SELECT * FROM (" +
            "    SELECT s1_0.supplier_id, s1_0.company_name, s1_0.website, " +
            "           s1_0.location, s1_0.nature_of_business, s1_0.manufacturing_processes, " +
            "           ROW_NUMBER() OVER (ORDER BY s1_0.supplier_id) AS rn " +
            "    FROM supplier s1_0 " +
            "    WHERE s1_0.location = :location " +
            "      AND s1_0.nature_of_business = :natureOfBusiness " +
            "      AND s1_0.manufacturing_processes = :manufacturingProcesses " +
            ") " +
            "WHERE rn BETWEEN :start AND :end", nativeQuery = true)
List<Supplier> findSuppliersWithPagination(
     @Param("location") String location,
     @Param("natureOfBusiness") String natureOfBusiness,
     @Param("manufacturingProcesses") String manufacturingProcesses,
     @Param("start") int start,
     @Param("end") int end);

	
}


	


