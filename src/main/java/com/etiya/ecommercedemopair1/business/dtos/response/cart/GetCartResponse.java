package com.etiya.ecommercedemopair1.business.dtos.response.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCartResponse {
    private int id;

    private double totalPrice;

    private int customerId;
}
