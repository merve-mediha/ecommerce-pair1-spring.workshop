package com.etiya.ecommercedemopair1.business.dtos.request.cart;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCartRequest {

    private double totalPrice;

    @NotNull
    private int customerId;
}
