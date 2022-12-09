package com.etiya.ecommercedemopair1.api.controllers;

import com.etiya.ecommercedemopair1.business.abstracts.AddressService;
import com.etiya.ecommercedemopair1.business.constants.Paths;
import com.etiya.ecommercedemopair1.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.address.GetAddressResponse;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.core.util.results.Result;
import com.etiya.ecommercedemopair1.entities.concretes.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "addresses")
public class AddressesController {
    private AddressService addressService;

    @Autowired
    public AddressesController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/getAllAddresses")
    public DataResult<List<GetAddressResponse>> getAll() {
        return this.addressService.getAll();
    }


    @GetMapping("/getAddressesByCityName")
    public DataResult<List<GetAddressResponse>> getAddressesByCityName(@RequestParam String name){
        return addressService.getAddressesByCityName(name);
    }
    @PostMapping("/addAddress")
    public Result addAddressInfo(@RequestBody @Valid AddAddressRequest addAddressRequest) {
       return addressService.addAddressInfo(addAddressRequest);

    }
    @PostMapping("addAddressGetInfo")
    public ResponseEntity<DataResult<GetAddressResponse>> addAddressWithInfo(@RequestBody AddAddressRequest addAddressRequest) {
        return new ResponseEntity<DataResult<GetAddressResponse>>(this.addressService.getAddressWithInfo(addAddressRequest), HttpStatus.CREATED);
    }
}
