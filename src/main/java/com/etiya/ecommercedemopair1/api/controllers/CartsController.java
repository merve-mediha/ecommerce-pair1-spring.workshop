package com.etiya.ecommercedemopair1.api.controllers;

import com.etiya.ecommercedemopair1.business.abstracts.CartService;
import com.etiya.ecommercedemopair1.business.constants.Paths;
import com.etiya.ecommercedemopair1.business.dtos.request.cart.AddCartRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.cart.GetCartResponse;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.repository.abstracts.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"carts")
public class CartsController {
    private CartService cartService;
    private final CartRepository cartRepository;

    @Autowired
    public CartsController(CartService cartService,
                           CartRepository cartRepository) {
        this.cartService = cartService;
        this.cartRepository = cartRepository;
    }

    @PostMapping("/add")
    public DataResult<GetCartResponse> addCart(@RequestBody @Valid AddCartRequest addCartRequest){
        return cartService.addCart(addCartRequest);
    }

    @GetMapping("/getAll")
    public DataResult<List<GetCartResponse>> getAll(){
        return cartService.getAll();
    }
}
