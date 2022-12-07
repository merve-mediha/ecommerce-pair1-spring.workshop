package com.etiya.ecommercedemopair1.business.abstracts;


import com.etiya.ecommercedemopair1.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.address.GetAddressResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAddressesByCityName(String name);

    Address getById(int id);
    List<Address> getAll();

    void addAddress(Address address);

    void addAddressInfo(AddAddressRequest addAddressRequest);

    GetAddressResponse getAddressWithInfo(AddAddressRequest addAddressRequest);

}
