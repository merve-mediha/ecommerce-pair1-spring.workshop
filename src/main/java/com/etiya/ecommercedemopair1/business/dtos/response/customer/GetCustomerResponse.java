package com.etiya.ecommercedemopair1.business.dtos.response.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetCustomerResponse {
    private int id;
    private String email;
    private String name;
    private String phone;
    private Date birth_date;
    private String gender;
}
