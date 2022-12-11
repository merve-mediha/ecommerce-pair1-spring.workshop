package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.response.order.GetOrderResponse;

import java.util.List;

public interface OrderService {
    List<GetOrderResponse> getOrderWithAddressId(int identity);
}
