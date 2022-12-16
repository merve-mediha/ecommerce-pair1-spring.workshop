package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.request.order.AddOrderRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.order.GetOrderResponse;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;

import java.util.List;

public interface OrderService {
    List<GetOrderResponse> getOrderWithAddressId(int identity);

    DataResult<GetOrderResponse> addOrder(AddOrderRequest addOrderRequest);
}
