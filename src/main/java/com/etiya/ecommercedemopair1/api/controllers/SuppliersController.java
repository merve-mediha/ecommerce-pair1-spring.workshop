package com.etiya.ecommercedemopair1.api.controllers;

import com.etiya.ecommercedemopair1.business.abstracts.SupplierService;
import com.etiya.ecommercedemopair1.business.constants.Paths;
import com.etiya.ecommercedemopair1.business.dtos.request.supplier.AddSupplierRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.supplier.GetSupplierResponse;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.core.util.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix +"supplier")
public class SuppliersController {
    private SupplierService supplierService;

    @Autowired
    public SuppliersController(SupplierService supplierService) { // Dependency Injection
        this.supplierService = supplierService;
    }

    @PostMapping("/addSupplier")
    public Result addSupplier(@RequestBody AddSupplierRequest addSupplierRequest) {
        return this.supplierService.addSupplier(addSupplierRequest);
    }

    @PostMapping("/addSupplierGetInfo")
    public DataResult<GetSupplierResponse> addSupplierGetInfo(@RequestBody AddSupplierRequest addSupplierRequest) {
        return supplierService.addSupplierWithInfo(addSupplierRequest);
    }

    @GetMapping("/getAll")
    public DataResult<List<GetSupplierResponse>> getAll(){
        return supplierService.getAll();
    }
}
