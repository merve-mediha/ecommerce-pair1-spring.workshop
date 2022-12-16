package com.etiya.ecommercedemopair1.api.controllers;

import com.etiya.ecommercedemopair1.business.abstracts.OrderService;
import com.etiya.ecommercedemopair1.business.constants.Paths;
import com.etiya.ecommercedemopair1.business.dtos.request.order.AddOrderRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.order.GetOrderResponse;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "orders")
public class OrdersController {
    private OrderService orderService;

    @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getByAddressId")
    public List<GetOrderResponse> getOrderWithAddressId(@RequestParam("identity") int identity){
        return orderService.getOrderWithAddressId(identity);
    }

    @PostMapping("/add")
    public DataResult<GetOrderResponse> addOrder(AddOrderRequest addOrderRequest){
        return orderService.addOrder(addOrderRequest);
    }
}
