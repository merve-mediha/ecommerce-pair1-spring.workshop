package com.etiya.ecommercedemopair1.business.dtos.response.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCountryResponse {
    private int country_id;
    private String name;
}
