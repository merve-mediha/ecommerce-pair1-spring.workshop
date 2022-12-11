package com.etiya.ecommercedemopair1.repository.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.response.order.GetOrderResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {


    @Query("select new com.etiya.ecommercedemopair1.business.dtos.response.order.GetOrderResponse(o.id,o.orderDate,o.paymentMethod,o.isCompleted) from Order" +
            " as o inner join Address as a" +
            " on o.address=a where a.id in(:identity) " +
            "group by o.id,o.orderDate,o.paymentMethod,o.isCompleted")
    List<GetOrderResponse> getOrderWithAddressId(int identity);

}
