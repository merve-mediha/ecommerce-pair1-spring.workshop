package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.AddressService;
import com.etiya.ecommercedemopair1.business.abstracts.CityService;
import com.etiya.ecommercedemopair1.business.abstracts.CountryService;
import com.etiya.ecommercedemopair1.business.abstracts.UserService;
import com.etiya.ecommercedemopair1.business.constants.Messages;
import com.etiya.ecommercedemopair1.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.address.GetAddressResponse;
import com.etiya.ecommercedemopair1.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair1.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.core.util.results.Result;
import com.etiya.ecommercedemopair1.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair1.core.util.results.SuccessResult;
import com.etiya.ecommercedemopair1.entities.concretes.*;
import com.etiya.ecommercedemopair1.repository.abstracts.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {

    private AddressRepository addressRepository;
    private UserService userService;
    private CityService cityService;
    private CountryService countryService;
    private final ModelMapperService modelMapperService;



    @Override
    public DataResult<List<GetAddressResponse>> getAddressesByCityName(String name) {
        List<Address> addresses = addressRepository.findAddressByCityName(name);
        List<GetAddressResponse> responses = addresses.stream().map(address -> modelMapperService.getMapperforResponse().map(address,GetAddressResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAddressResponse>>(responses, Messages.AllSuffix.getAllSuffixOfMessages + "by city name");
    }

    @Override
    public DataResult<GetAddressResponse> getById(int id) {
        Address address = addressRepository.findById(id).orElseThrow();
        GetAddressResponse response = modelMapperService.getMapperforResponse().map(address, GetAddressResponse.class);
        return new SuccessDataResult<GetAddressResponse>(response, Messages.AllSuffix.getByIdSuffixOfMessages);
    }

    @Override
    public DataResult<List<GetAddressResponse>> getAll() {
        List<Address> addresses = addressRepository.findAll();
        List<GetAddressResponse> responses = addresses.stream().map(address -> modelMapperService.getMapperforResponse().map(address, GetAddressResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAddressResponse>>(responses, Messages.AllSuffix.addSuffixOfMessages);
    }


    @Override
    public Result addAddressInfo(AddAddressRequest addAddressRequest) {
        checkUserExists(addAddressRequest.getUserId());
        checkCityExists(addAddressRequest.getCityId());
        // Mapping - > map the attributes from the request to the attributes of the object we created ourselves.
        Address address = modelMapperService.getMapperforRequest().map(addAddressRequest,Address.class);
        addressRepository.save(address);

    return new SuccessResult(Messages.AllSuffix.addSuffixOfMessages);


    }

    @Override
    public DataResult<GetAddressResponse> getAddressWithInfo(AddAddressRequest addAddressRequest) {
        Address address =modelMapperService.getMapperforRequest().map(addAddressRequest,Address.class);

        checkUserExists(addAddressRequest.getUserId());
        checkCityExists(addAddressRequest.getCityId());
        Address savedAddress = addressRepository.saveAndFlush(address);

        GetAddressResponse getAddressResponse = modelMapperService.getMapperforResponse().map(savedAddress,GetAddressResponse.class);

        return new SuccessDataResult<GetAddressResponse>(getAddressResponse, Messages.AllSuffix.addSuffixOfMessages);
    }


    private void checkUserExists(int id) {

        boolean isExist = userService.existsById(id);
        if (!isExist) {
            throw new BusinessException(Messages.User.userExists);
        }
    }

    private void checkCityExists(int id) {

        boolean isExist = cityService.existsById(id);
        if (!isExist) {
            throw new BusinessException(Messages.City.cityExists);
        }
    }

    private void checkCountryExists(int id) {

        boolean isExist = countryService.existsById(id);
        if (!isExist) {
            throw new BusinessException(Messages.Country.countryExists);
        }
    }
}
