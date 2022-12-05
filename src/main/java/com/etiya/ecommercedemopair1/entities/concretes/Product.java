package com.etiya.ecommercedemopair1.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double unitPrice;

    @Column(name = "stock")
    private int stock;

    @Column(name = "discount_rate")
    private double discountRate;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "product")
    private List<ProductCategory> productCategories;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "product")
    private List<ProductCart> productCarts;

}

