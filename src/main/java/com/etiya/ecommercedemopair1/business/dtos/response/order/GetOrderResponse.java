package com.etiya.ecommercedemopair1.business.dtos.response.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetOrderResponse {
    private int id;
    private Date orderDate;
    private String paymentMethod;
    private boolean isCompleted;


}
