package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.customer.GetCustomerResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Customer;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    Customer getById(int id);
//    Customer findCustomerWhereAddressId(int id);

    String findEmailByName(String name);
    List<Customer> getCustomerWithGender(String gender);

    void addCustomer(AddCustomerRequest addCustomerRequest); // Sadece Request'li görelim.

    GetCustomerResponse addCustomerWithCustomerInfo(AddCustomerRequest addCustomerRequest); // Bir de Response'lu görelim.addCustomer gibi.

    boolean existsById(int id);
}
