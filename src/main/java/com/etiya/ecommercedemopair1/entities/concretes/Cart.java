package com.etiya.ecommercedemopair1.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="customer_id")
    private Customer customer;


    @OneToMany(mappedBy="cart")
    private List<ProductCart> productCarts;
}
