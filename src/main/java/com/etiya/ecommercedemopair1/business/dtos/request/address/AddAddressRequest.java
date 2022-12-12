package com.etiya.ecommercedemopair1.business.dtos.request.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddAddressRequest {
    private int postalCode;
    private String street;
    private String title;


    //private User user;
    //private City city;
    //private Country country;
    @Min(value = 0)
    private int userId;
    @Min(value = 0)
    private int cityId;



}
