package com.makersharks.suppliersearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.makersharks.suppliersearch.model.Supplier;
import com.makersharks.suppliersearch.service.SupplierService;


@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    @Autowired
    private SupplierService service;

    @PostMapping("/query")
    public List<Supplier> querySuppliers(
            @RequestParam String location,
            @RequestParam String natureOfBusiness,
            @RequestParam String manufacturingProcesses) {
        return service.getSuppliers(location, natureOfBusiness, manufacturingProcesses);
    }
    
 // Add pagination parameters to the endpoint
    
    @PostMapping("/query1")
    public ResponseEntity<List<Supplier>> querySuppliers(
            @RequestParam String location,
            @RequestParam String natureOfBusiness,
            @RequestParam String manufacturingProcesses,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        try {
            List<Supplier> suppliers = service.searchSuppliers(location, natureOfBusiness, manufacturingProcesses, page, size);
            return new ResponseEntity<>(suppliers, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and return an appropriate response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

