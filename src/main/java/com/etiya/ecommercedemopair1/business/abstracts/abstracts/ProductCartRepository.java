package com.etiya.ecommercedemopair1.business.abstracts.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCartRepository extends JpaRepository<ProductCart, Integer> {
}
