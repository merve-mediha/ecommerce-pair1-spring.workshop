package com.etiya.ecommercedemopair1.business.dtos.request.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {
    private boolean isCompleted;
    private int addressId;
    private int cartId;
}
