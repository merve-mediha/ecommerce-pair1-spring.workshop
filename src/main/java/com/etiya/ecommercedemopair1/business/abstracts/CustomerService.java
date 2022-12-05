package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Customer;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    Customer getById(int id);
//    Customer findCustomerWhereAddressId(int id);

    List<Customer> getCustomerWithGender(String gender);
    String findEmailByName(String name);
}
