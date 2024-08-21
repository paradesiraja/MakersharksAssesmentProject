package com.makersharks.suppliersearch.model;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long supplierId;

    private String companyName;

    private String website;

    private String location;

    @Column(name = "nature_of_business")
    private String natureOfBusiness;

    @Column(name = "manufacturing_processes")
    private String manufacturingProcesses;

	

    
}

