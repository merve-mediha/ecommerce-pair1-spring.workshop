package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.core.util.results.Result;

import java.util.List;

public interface CityService {

    DataResult<AddCityResponse> addCity(AddCityRequest addCityRequest);

    Result addCity2(AddCityRequest addCityRequest);

    DataResult<List<AddCityResponse>> getAll();
    boolean existsById(int id);
}
