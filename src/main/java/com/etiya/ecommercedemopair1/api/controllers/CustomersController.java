package com.etiya.ecommercedemopair1.api.controllers;

import com.etiya.ecommercedemopair1.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair1.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.customer.GetCustomerResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/customers")
@RestController
public class CustomersController {
    private final CustomerService customerService;

    @Autowired
    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getAll")
    public List<Customer> getAll(){
        return customerService.getAll();
    }
    @GetMapping("/getById/{id}")
    public Customer getById(@PathVariable int id) {
        return this.customerService.getById(id);
    }

    @GetMapping("/getEmail")
    public String findEmailByName(@RequestParam("name") String name) {
        return this.customerService.findEmailByName(name);
    }

    @GetMapping("/getCustomerByGender")
    public List<Customer> getCustomerWithGender(@RequestParam("gender") String gender) {
        return this.customerService.getCustomerWithGender(gender);
    }

    @PostMapping("/addCustomer")
    public void addCustomer(@RequestBody AddCustomerRequest addCustomerRequest) {
        customerService.addCustomer(addCustomerRequest);
    }

    @PostMapping("/addCustomerWithCustomerInfo")
    public ResponseEntity<GetCustomerResponse> addCustomerWithCustomerInfo(@RequestBody AddCustomerRequest addCustomerRequest) {

        return new ResponseEntity<GetCustomerResponse>(customerService.addCustomerWithCustomerInfo(addCustomerRequest),
                HttpStatus.CREATED);
    }




}

