package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.request.supplier.AddSupplierRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.supplier.GetSupplierResponse;

public interface SupplierService {
    public void addSupplier(AddSupplierRequest addSupplierRequest);

    GetSupplierResponse getSupplierWithInfo(AddSupplierRequest addSupplierRequest);
}
