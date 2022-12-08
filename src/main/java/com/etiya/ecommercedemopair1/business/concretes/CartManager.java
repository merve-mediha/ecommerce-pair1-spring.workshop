package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.CartService;
import com.etiya.ecommercedemopair1.business.dtos.request.cart.AddCartRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.cart.GetCartResponse;
import com.etiya.ecommercedemopair1.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.entities.concretes.Cart;
import com.etiya.ecommercedemopair1.repository.abstracts.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartManager implements CartService {
    private CartRepository cartRepository;
    private ModelMapperService modelMapperService;
    @Autowired
    public CartManager(CartRepository cartRepository,ModelMapperService modelMapperService) {
        this.cartRepository = cartRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    @Override
    public GetCartResponse addCartGetResponse(AddCartRequest addCartRequest) {
        Cart cart = modelMapperService.getMapperforRequest().map(addCartRequest, Cart.class);
        Cart savedCart = cartRepository.save(cart);
        GetCartResponse response = modelMapperService.getMapperforResponse().map(savedCart,
                GetCartResponse.class);
        return response;
    }
}
