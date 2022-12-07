package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.SupplierService;
import com.etiya.ecommercedemopair1.business.dtos.request.supplier.AddSupplierRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.supplier.GetSupplierResponse;
import com.etiya.ecommercedemopair1.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.entities.concretes.Supplier;
import com.etiya.ecommercedemopair1.repository.abstracts.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SupplierManager implements SupplierService {

    private SupplierRepository supplierRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public void addSupplier(AddSupplierRequest addSupplierRequest) {
        // Matching
        Supplier supplier = modelMapperService.getMapperforRequest().map(addSupplierRequest, Supplier.class);

        supplierRepository.save(supplier);
    }

    @Override
    public GetSupplierResponse getSupplierWithInfo(AddSupplierRequest addSupplierRequest) {
        // Matching
        Supplier supplier = modelMapperService.getMapperforRequest().map(addSupplierRequest, Supplier.class);

       Supplier savedSupplier =  supplierRepository.save(supplier);


        GetSupplierResponse getSupplierResponse = modelMapperService.getMapperforResponse().map(savedSupplier, GetSupplierResponse.class);
        return getSupplierResponse;

    }
}
