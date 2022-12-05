package com.etiya.ecommercedemopair1.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="total_price")
    private double totalPrice;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "cart")
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy="cart")
    private List<ProductCart> productCarts;
}
