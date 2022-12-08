package com.etiya.ecommercedemopair1.business.dtos.response.supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSupplierResponse {
    private String email;
    private String name;
    private String phone;
    private Date birth_date;
    private String description;
}
