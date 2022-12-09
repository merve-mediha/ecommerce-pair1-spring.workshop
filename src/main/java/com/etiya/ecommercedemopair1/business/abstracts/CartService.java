package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.request.cart.AddCartRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.cart.GetCartResponse;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;

import java.util.List;

public interface CartService {
    DataResult<List<GetCartResponse>> getAll();

    DataResult<GetCartResponse> addCart(AddCartRequest addCartRequest);

}
