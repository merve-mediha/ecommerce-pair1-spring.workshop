package com.etiya.ecommercedemopair1.repository.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllProductsByStockGreaterThanOrderByStockAsc(int stock);
    List<Product> findAllByOrderByNameAsc();

    @Query("Select p.name from Product as p where p.id=:id")
    String getProductNameWithId(int id);

}
