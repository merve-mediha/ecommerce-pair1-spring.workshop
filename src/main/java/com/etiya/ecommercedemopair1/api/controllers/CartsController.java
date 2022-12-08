package com.etiya.ecommercedemopair1.api.controllers;

import com.etiya.ecommercedemopair1.business.abstracts.CartService;
import com.etiya.ecommercedemopair1.business.dtos.request.cart.AddCartRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.cart.GetCartResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Cart;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartsController {
    private CartService cartService;

    @Autowired
    public CartsController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/getAll")
    public List<Cart> getAll(){
        return cartService.getAll();
    }

    @PostMapping("/addCartWithResponse")
    public ResponseEntity<GetCartResponse> addCartGetResponse(@RequestBody AddCartRequest addCartRequest){
        return new ResponseEntity<GetCartResponse>(this.cartService.addCartGetResponse(addCartRequest), HttpStatus.CREATED );
    }
}
