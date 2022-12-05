package com.etiya.ecommercedemopair1.business.dto;

import com.etiya.ecommercedemopair1.entities.concretes.City;
import com.etiya.ecommercedemopair1.entities.concretes.Country;
import com.etiya.ecommercedemopair1.entities.concretes.Order;
import com.etiya.ecommercedemopair1.entities.concretes.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAddressDto {

    private int id;

    private int postalcode;

    private String street;

    private String title;

   private int user;

    private int city;

    private int country;

}
