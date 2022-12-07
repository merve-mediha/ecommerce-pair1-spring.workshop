package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair1.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.customer.GetCustomerResponse;
import com.etiya.ecommercedemopair1.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.entities.concretes.Customer;
import com.etiya.ecommercedemopair1.repository.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(int id) {
        return customerRepository.findById(id).orElseThrow();
    }

    @Override
    public String findEmailByName(String name) {
        return this.customerRepository.findEmailByName(name);
    }

    @Override
    public List<Customer> getCustomerWithGender(String gender) {
        return customerRepository.getCustomerWithGender(gender);
    }

    @Override
    public void addCustomer(AddCustomerRequest addCustomerRequest) {
        // this.customerRepository.save(customer);

        // Mapping
        Customer customer = modelMapperService.getMapperforRequest().map(addCustomerRequest, Customer.class);



        customerRepository.save(customer);

    }

    @Override
    public GetCustomerResponse addCustomerWithCustomerInfo(AddCustomerRequest addCustomerRequest) {
        // return this.customerRepository.save(addCustomerRequest);
        // Mapping
        Customer customer = modelMapperService.getMapperforRequest().map(addCustomerRequest, Customer.class);

        Customer savedCustomer = customerRepository.save(customer);

        GetCustomerResponse getCustomerResponse = modelMapperService.getMapperforResponse().map(savedCustomer,GetCustomerResponse.class);

        return getCustomerResponse;
    }
}
