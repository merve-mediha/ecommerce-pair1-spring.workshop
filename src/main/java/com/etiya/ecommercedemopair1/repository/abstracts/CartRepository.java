package com.etiya.ecommercedemopair1.repository.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Cart;
import com.etiya.ecommercedemopair1.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CartRepository extends JpaRepository<Cart, Integer> {
    boolean existsById(int id);

    @Query("Select p from Product p JOIN p.productCarts pcart JOIN pcart.cart c where c.id=:id")
    List<Product> findProductsByCartId(@Param("id") int id);
}
