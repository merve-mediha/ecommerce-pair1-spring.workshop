package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair1.entities.concretes.Customer;
import com.etiya.ecommercedemopair1.repository.abstracts.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }



    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(int id) {
        return customerRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Customer> getCustomerWithGender(String gender) {
        return customerRepository.getCustomerWithGender(gender);
    }

    @Override
    public String findEmailByName(String name) {
        return customerRepository.findEmailByName(name);
    }


//    @Override
//    public Customer findCustomerWhereAddressId(int id) {
//        return customerRepository.findCustomerWhereAddressId(id);
//    }



}
