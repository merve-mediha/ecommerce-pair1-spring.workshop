package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.AddressService;
import com.etiya.ecommercedemopair1.business.dtos.AddAddressRequest;
import com.etiya.ecommercedemopair1.entities.concretes.Address;
import com.etiya.ecommercedemopair1.entities.concretes.City;
import com.etiya.ecommercedemopair1.entities.concretes.Country;
import com.etiya.ecommercedemopair1.entities.concretes.User;
import com.etiya.ecommercedemopair1.repository.abstracts.AddressRepository;
import com.etiya.ecommercedemopair1.repository.abstracts.CityRepository;
import com.etiya.ecommercedemopair1.repository.abstracts.CountryRepository;
import com.etiya.ecommercedemopair1.repository.abstracts.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class AddressManager implements AddressService {

    private AddressRepository addressRepository;
    private UserRepository userRepository;
    private CountryRepository countryRepository;
    private CityRepository cityRepository;

    @Autowired
    public AddressManager(AddressRepository addressRepository,UserRepository userRepository,CountryRepository countryRepository,CityRepository cityRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public List<Address> getAddressesByCityName(String name) {
        return addressRepository.getAddressesByCityNameUsingNative(name);
    }

    @Override
    public Address getById(int id) {
        return null;
    }

    @Override
    public void addAddressWithInfo(AddAddressRequest addAddressRequest) {
        Address address = new Address();
        address.setStreet(addAddressRequest.getStreet());
        address.setTitle(addAddressRequest.getTitle());
        address.setPostalCode(addAddressRequest.getPostalCode());
        address.setUser(userRepository.findById(addAddressRequest.getUserId()));
        address.setCity(cityRepository.findById(addAddressRequest.getCityId()));
        address.setCountry(countryRepository.findById(addAddressRequest.getCountryId()));
        addressRepository.save(address);

    }
}