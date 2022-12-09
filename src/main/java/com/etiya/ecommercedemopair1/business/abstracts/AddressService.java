package com.etiya.ecommercedemopair1.business.abstracts;


import com.etiya.ecommercedemopair1.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.address.GetAddressResponse;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.core.util.results.Result;
import com.etiya.ecommercedemopair1.entities.concretes.Address;
import com.etiya.ecommercedemopair1.entities.concretes.Product;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressService {
    DataResult<List<GetAddressResponse>> getAddressesByCityName(String name);

    Result getById(int id);
    DataResult<List<GetAddressResponse>> getAll();


    Result addAddress(AddAddressRequest addAddressRequest);

    Result addAddressInfo(AddAddressRequest addAddressRequest);

    DataResult<GetAddressResponse> getAddressWithInfo(AddAddressRequest addAddressRequest);


}
