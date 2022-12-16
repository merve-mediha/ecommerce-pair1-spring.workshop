package com.etiya.ecommercedemopair1.business.dtos.response.productCart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductCartResponse {
    private int productId;
    private int cartId;
}
