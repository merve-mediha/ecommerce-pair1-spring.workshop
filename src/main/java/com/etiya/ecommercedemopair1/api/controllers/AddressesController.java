package com.etiya.ecommercedemopair1.api.controllers;

import com.etiya.ecommercedemopair1.business.abstracts.AddressService;
import com.etiya.ecommercedemopair1.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.address.GetAddressResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressesController {
    private AddressService addressService;

    @Autowired
    public AddressesController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/getAllAddresses")
    public List<Address> getAll() {
        return this.addressService.getAll();
    }


    @GetMapping("/getAddressesByCityName")
    public List<Address> getAddressesByCityName(@RequestParam String name){
        return addressService.getAddressesByCityName(name);
    }
    @PostMapping("/addAddress")
    public void addAddressInfo(@RequestBody @Valid AddAddressRequest addAddressRequest){
        addressService.addAddressInfo(addAddressRequest);
}
    @PostMapping("addAddressGetInfo")
    public ResponseEntity<GetAddressResponse> addAddressWithInfo(@RequestBody AddAddressRequest addAddressRequest) {
        return new ResponseEntity<GetAddressResponse>(this.addressService.getAddressWithInfo(addAddressRequest), HttpStatus.CREATED);
    }
}
