package com.etiya.ecommercedemopair1.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Order  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="order_date")
    private Date orderDate;



    @Column(name="isCompleted")
    private boolean isCompleted;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="address_id")
    @JsonBackReference
    private Address address;

    @OneToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderDelivery> orderDeliveries;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "order")
    private List<Payment> payments ;


}
