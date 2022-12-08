package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.request.cart.AddCartRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.cart.GetCartResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getAll();

    GetCartResponse addCartGetResponse(AddCartRequest addCartRequest);
}