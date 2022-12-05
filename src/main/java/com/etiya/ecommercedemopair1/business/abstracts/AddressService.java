package com.etiya.ecommercedemopair1.business.abstracts;


import com.etiya.ecommercedemopair1.entities.concretes.Address;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressService {
    List<Address> getAddressesByCityName(String name);
}
