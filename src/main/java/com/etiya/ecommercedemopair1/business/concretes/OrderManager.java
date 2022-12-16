package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.AddressService;
import com.etiya.ecommercedemopair1.business.abstracts.CartService;
import com.etiya.ecommercedemopair1.business.abstracts.OrderService;
import com.etiya.ecommercedemopair1.business.constants.Messages;
import com.etiya.ecommercedemopair1.business.dtos.request.order.AddOrderRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.order.GetOrderResponse;
import com.etiya.ecommercedemopair1.business.dtos.response.productCart.GetProductCartResponse;
import com.etiya.ecommercedemopair1.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair1.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair1.entities.concretes.*;
import com.etiya.ecommercedemopair1.repository.abstracts.AddressRepository;
import com.etiya.ecommercedemopair1.repository.abstracts.CartRepository;
import com.etiya.ecommercedemopair1.repository.abstracts.InvoiceRepository;
import com.etiya.ecommercedemopair1.repository.abstracts.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {
    private OrderRepository orderRepository;
    private ModelMapperService modelMapperService;
    private CartService cartService;
    private AddressService addressService;
    private final InvoiceRepository invoiceRepository;

    @Override
    public List<GetOrderResponse> getOrderWithAddressId(int identity) {
        return orderRepository.getOrderWithAddressId(identity);
    }

    @Override
    @Transactional
    public DataResult<GetOrderResponse> addOrder(AddOrderRequest addOrderRequest) {
        checkAddressIfExists(addOrderRequest.getAddressId());
        checkProductAtCart(addOrderRequest.getCartId());

        Order order = modelMapperService.getMapperforRequest().map(addOrderRequest, Order.class);
        order.setOrderDate(Date.from(Instant.now()));

        List<Product> products = cartService.findProductsByCartId(addOrderRequest.getCartId());
        List<GetProductCartResponse> getProductCartResponses = new ArrayList<>();
        for (Product product : products) {
            getProductCartResponses.add(new GetProductCartResponse(product.getId(), addOrderRequest.getCartId()));
        }
        List<ProductCart> productCarts = getProductCartResponses.stream().map(getProductCartResponse -> this.modelMapperService.getMapperforResponse().map(getProductCartResponse, ProductCart.class)).collect(Collectors.toList());


        Order savedOrder = orderRepository.save(order);
        Cart cart = savedOrder.getCart();
        cart.setProductCarts(productCarts);
        Invoice invoice = new Invoice();
        invoice.setInvoiceDate(LocalDate.now());
        invoice.setTotalInvoicePrice(cart.getTotalPrice());
        invoice.setOrder(savedOrder);
        invoiceRepository.save(invoice);

        GetOrderResponse response = modelMapperService.getMapperforResponse().map(savedOrder, GetOrderResponse.class);

        return new SuccessDataResult<GetOrderResponse>(response, Messages.AllSuffix.addSuffixOfMessages);

    }

    public void checkProductAtCart(int id) {
        List<Product> products = cartService.findProductsByCartId(id);
        if (products.size() == 0) {
            throw new BusinessException("Cart has any product");

        }
    }
    public void checkAddressIfExists(int id)
    {
        boolean isExists=addressService.existsById(id);
        if(!isExists)
        {
            throw new BusinessException("Address couldnot found");
        }

    }
}
