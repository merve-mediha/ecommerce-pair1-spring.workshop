package com.etiya.ecommercedemopair1.business.abstracts.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
