package com.etiya.ecommercedemopair1.api.controllers;

import com.etiya.ecommercedemopair1.business.abstracts.CityService;
import com.etiya.ecommercedemopair1.business.constants.Paths;
import com.etiya.ecommercedemopair1.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.core.util.results.Result;
import com.etiya.ecommercedemopair1.core.util.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "cities")
public class CitiesController {
    private CityService cityService;

    @Autowired
    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add")
    public DataResult<AddCityResponse> addCity(AddCityRequest addCityRequest){
        return cityService.addCity(addCityRequest);
    }

    @GetMapping("/getAll")
    public DataResult<List<AddCityResponse>> getAll(){
        return cityService.getAll();
    }

    @PostMapping("/add2")
    public Result addCity2(AddCityRequest addCityRequest){
        return cityService.addCity2(addCityRequest);
    }

}
