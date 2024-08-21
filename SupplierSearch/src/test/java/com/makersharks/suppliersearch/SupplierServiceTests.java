package com.makersharks.suppliersearch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.makersharks.suppliersearch.model.Supplier;
import com.makersharks.suppliersearch.repository.SupplierRepository;
import com.makersharks.suppliersearch.service.SupplierService;

@SpringBootTest
public class SupplierServiceTests {

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private SupplierService supplierService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetSuppliers() {
        Supplier supplier = new Supplier();
        supplier.setSupplierId(1L);
        supplier.setCompanyName("Test Company");
        supplier.setWebsite("http://testcompany.com");
        supplier.setLocation("India");
        supplier.setNatureOfBusiness("small_scale");
        supplier.setManufacturingProcesses("3d_printing");

        List<Supplier> suppliers = Collections.singletonList(supplier);

        when(supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcesses(
                "India", "small_scale", "3d_printing"))
                .thenReturn(suppliers);

        List<Supplier> result = supplierService.getSuppliers("India", "small_scale", "3d_printing");

        assertEquals(1, result.size());
        assertEquals("Test Company", result.get(0).getCompanyName());
    }
}

