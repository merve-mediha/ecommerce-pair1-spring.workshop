package com.etiya.ecommercedemopair1.api.controllers;

import com.etiya.ecommercedemopair1.business.abstracts.AddressService;
import com.etiya.ecommercedemopair1.entities.concretes.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressesController {
    private AddressService addressService;

    @Autowired
    public AddressesController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/getAddressesByCityName")
    public List<Address> getAddressesByCityName(@RequestParam String name){
        return addressService.getAddressesByCityName(name);
    }
}
