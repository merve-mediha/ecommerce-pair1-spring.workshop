package com.etiya.ecommercedemopair1.api.controllers;

import com.etiya.ecommercedemopair1.business.abstracts.CountryService;
import com.etiya.ecommercedemopair1.business.constants.Paths;
import com.etiya.ecommercedemopair1.business.dtos.request.country.AddCountryRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.country.AddCountryResponse;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix +"countries")
public class CountriesController {
    private CountryService countryService;
    @Autowired
    public CountriesController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/add")
    public ResponseEntity<DataResult<AddCountryResponse>> addCountry(AddCountryRequest addCountryRequest){
        return new ResponseEntity<DataResult<AddCountryResponse>>(countryService.addCountry(addCountryRequest), HttpStatus.CREATED) ;
    }

    @GetMapping("/getAll")
    public DataResult<List<AddCountryResponse>> getAll(){
        return countryService.getAll();
    }
}
