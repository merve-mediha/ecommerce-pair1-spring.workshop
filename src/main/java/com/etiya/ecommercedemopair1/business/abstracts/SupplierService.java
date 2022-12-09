package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.request.supplier.AddSupplierRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.supplier.GetSupplierResponse;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.core.util.results.Result;

import java.util.List;

public interface SupplierService {
    Result addSupplier(AddSupplierRequest addSupplierRequest);

    DataResult<GetSupplierResponse> addSupplierWithInfo(AddSupplierRequest addSupplierRequest);

    DataResult<List<GetSupplierResponse>> getAll();
}
