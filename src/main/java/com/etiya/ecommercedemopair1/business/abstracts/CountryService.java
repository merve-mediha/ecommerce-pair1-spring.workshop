package com.etiya.ecommercedemopair1.business.abstracts;


import com.etiya.ecommercedemopair1.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemopair1.business.dtos.request.country.AddCountryRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemopair1.business.dtos.response.country.AddCountryResponse;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;

import java.util.List;

public interface CountryService {

   DataResult<AddCountryResponse> addCountry(AddCountryRequest addCountryRequest);

    DataResult<List<AddCountryResponse>> getAll();
    boolean existsById(int id);
}
