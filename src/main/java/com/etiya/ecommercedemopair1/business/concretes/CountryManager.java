package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.CountryService;
import com.etiya.ecommercedemopair1.business.constants.Messages;
import com.etiya.ecommercedemopair1.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemopair1.business.dtos.request.country.AddCountryRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemopair1.business.dtos.response.country.AddCountryResponse;
import com.etiya.ecommercedemopair1.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair1.entities.concretes.City;
import com.etiya.ecommercedemopair1.entities.concretes.Country;
import com.etiya.ecommercedemopair1.repository.abstracts.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CountryManager implements CountryService {
    private final CountryRepository countryRepository;

    private final ModelMapperService modelMapperService;
    @Override
    public DataResult<AddCountryResponse> addCountry(AddCountryRequest addCountryRequest) {
        Country country = modelMapperService.getMapperforRequest().map(addCountryRequest, Country.class);
        Country savedCountry = countryRepository.save(country);
        AddCountryResponse response = modelMapperService.getMapperforResponse()
                .map(savedCountry,AddCountryResponse.class);

        return new SuccessDataResult<AddCountryResponse>(response, Messages.AllSuffix.addSuffixOfMessages);
    }

    @Override
    public DataResult<List<AddCountryResponse>> getAll(){
        List<Country> countries = countryRepository.findAll();
        List<AddCountryResponse> responses = countries.stream()
                .map(country -> modelMapperService.getMapperforResponse()
                        .map(country,AddCountryResponse.class)).collect(Collectors.toList());
        return  new SuccessDataResult<List<AddCountryResponse>>(responses, Messages.AllSuffix.getAllSuffixOfMessages);
    }

    @Override
    public boolean existsById(int id) {
        return countryRepository.existsById(id);
    }
}
