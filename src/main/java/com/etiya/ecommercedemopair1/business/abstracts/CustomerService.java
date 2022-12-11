package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.customer.GetCustomerResponse;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.core.util.results.Result;
import com.etiya.ecommercedemopair1.entities.concretes.Customer;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerService {
    DataResult<List<GetCustomerResponse>> getAll();
    DataResult<GetCustomerResponse> getById(int id);
//    Customer findCustomerWhereAddressId(int id);

    String findEmailByName(String name);
    DataResult<List<GetCustomerResponse>> getCustomerWithGender(String gender);

    Result addCustomer(AddCustomerRequest addCustomerRequest); // Sadece Request'li görelim.

    DataResult<GetCustomerResponse> addCustomerWithCustomerInfo(AddCustomerRequest addCustomerRequest); // Bir de Response'lu görelim.addCustomer gibi.

    boolean existsById(int id);

    List<GetCustomerResponse> getCustomerResponseWithGender(String gender);
}
