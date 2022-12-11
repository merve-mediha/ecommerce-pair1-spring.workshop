package com.etiya.ecommercedemopair1.business.dtos.request.city;

import com.etiya.ecommercedemopair1.entities.concretes.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCityRequest {
    private String name;

    private int plateNumber;

    @NotNull
    private int countryId;
}
