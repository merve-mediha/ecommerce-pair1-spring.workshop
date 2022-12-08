package com.etiya.ecommercedemopair1.business.dtos.request.cart;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCartRequest {

    private double totalPrice;

    private int customerId;
}
