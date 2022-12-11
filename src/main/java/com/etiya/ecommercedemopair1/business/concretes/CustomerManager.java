package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair1.business.constants.Messages;
import com.etiya.ecommercedemopair1.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.customer.GetCustomerResponse;
import com.etiya.ecommercedemopair1.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.core.util.results.Result;
import com.etiya.ecommercedemopair1.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair1.core.util.results.SuccessResult;
import com.etiya.ecommercedemopair1.entities.concretes.Customer;
import com.etiya.ecommercedemopair1.repository.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;


    @Override
    public DataResult<List<GetCustomerResponse>> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<GetCustomerResponse> responses = customers.stream()
                .map(customer -> modelMapperService.getMapperforResponse()
                        .map(customer, GetCustomerResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetCustomerResponse>>(responses, Messages.AllSuffix.getAllSuffixOfMessages);
    }

    @Override
    public DataResult<GetCustomerResponse> getById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        GetCustomerResponse response = modelMapperService.getMapperforResponse().map(customer, GetCustomerResponse.class);
        return new SuccessDataResult<GetCustomerResponse>(response, Messages.AllSuffix.getByIdSuffixOfMessages);
    }

    @Override
    public String findEmailByName(String name) {
        return this.customerRepository.findEmailByName(name);
    }

    @Override
    public DataResult<List<GetCustomerResponse>> getCustomerWithGender(String gender) {
        List<Customer> customers = customerRepository.getCustomerWithGender(gender);
        List<GetCustomerResponse> responses = customers.stream()
                .map(customer -> modelMapperService.getMapperforResponse()
                        .map(customer, GetCustomerResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetCustomerResponse>>(responses, Messages.AllSuffix.getAllSuffixOfMessages + "by customers' gender");
    }
    @Override
    public List<GetCustomerResponse> getCustomerResponseWithGender(String gender) {
        return customerRepository.getCustomerResponseWithGender(gender);
    }

    @Override
    public Result addCustomer(AddCustomerRequest addCustomerRequest) {
        // this.customerRepository.save(customer);

        // Mapping
        Customer customer = modelMapperService.getMapperforRequest().map(addCustomerRequest, Customer.class);



        customerRepository.save(customer);
        return  new SuccessResult(Messages.AllSuffix.addSuffixOfMessages);

    }

    @Override
    public DataResult<GetCustomerResponse> addCustomerWithCustomerInfo(AddCustomerRequest addCustomerRequest) {
        // return this.customerRepository.save(addCustomerRequest);
        // Mapping
        Customer customer = modelMapperService.getMapperforRequest().map(addCustomerRequest, Customer.class);

        Customer savedCustomer = customerRepository.save(customer);

        GetCustomerResponse getCustomerResponse = modelMapperService.getMapperforResponse().map(savedCustomer,GetCustomerResponse.class);

        return new SuccessDataResult<GetCustomerResponse>(getCustomerResponse, Messages.AllSuffix.addSuffixOfMessages);
    }

    @Override
    public boolean existsById(int id) {
        return customerRepository.existsById(id);
    }


}
