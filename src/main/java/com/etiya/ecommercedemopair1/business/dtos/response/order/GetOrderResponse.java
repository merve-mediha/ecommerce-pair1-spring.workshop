package com.etiya.ecommercedemopair1.business.dtos.response.order;

import com.etiya.ecommercedemopair1.entities.concretes.Address;
import com.etiya.ecommercedemopair1.entities.concretes.Cart;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetOrderResponse {
    private int id;
    private Date orderDate;
    private boolean isCompleted;
    private int addressId;
    private int cartId;

    public GetOrderResponse(int id, Date orderDate, boolean isCompleted) {
        this.id = id;
        this.orderDate = orderDate;
        this.isCompleted = isCompleted;
    }
}
