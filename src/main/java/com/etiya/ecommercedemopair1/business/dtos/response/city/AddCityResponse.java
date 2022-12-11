package com.etiya.ecommercedemopair1.business.dtos.response.city;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCityResponse {
    private int city_id;

    private String name;

    private int plateNumber;

    private int countryId;
}
