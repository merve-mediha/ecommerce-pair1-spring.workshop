package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.CityService;
import com.etiya.ecommercedemopair1.business.constants.Messages;
import com.etiya.ecommercedemopair1.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemopair1.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.core.util.results.Result;
import com.etiya.ecommercedemopair1.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair1.core.util.results.SuccessResult;
import com.etiya.ecommercedemopair1.entities.concretes.City;
import com.etiya.ecommercedemopair1.repository.abstracts.AddressRepository;
import com.etiya.ecommercedemopair1.repository.abstracts.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityManager implements CityService {
    private final CityRepository cityRepository;
    private final ModelMapperService modelMapperService;
    private final AddressRepository addressRepository;


    @Override
    public DataResult<AddCityResponse> addCity(AddCityRequest addCityRequest) {
        City city = modelMapperService.getMapperforResponse().map(addCityRequest, City.class);
        City savedCity = cityRepository.save(city);
        AddCityResponse response = modelMapperService.getMapperforResponse().map(savedCity, AddCityResponse.class);
        return new SuccessDataResult<AddCityResponse>(response, Messages.AllSuffix.addSuffixOfMessages);
    }

    @Override
    public Result addCity2(AddCityRequest addCityRequest){
        City city =  modelMapperService.getMapperforResponse().map(addCityRequest, City.class);
        this.cityRepository.save(city);
        return new SuccessResult(Messages.AllSuffix.addSuffixOfMessages);
    }

    @Override
    public DataResult<List<AddCityResponse>> getAll(){
        List<City> cities = cityRepository.findAll();
        List<AddCityResponse> responses = cities.stream()
                .map(city -> modelMapperService.getMapperforResponse()
                        .map(city,AddCityResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<AddCityResponse>>(responses, Messages.AllSuffix.getAllSuffixOfMessages);
    }

    @Override
    public boolean existsById(int id) {
        return cityRepository.existsById(id);
    }
}
