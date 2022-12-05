package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Product;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(int id);

    List<Product> findAllProductsByStockGreaterThanOrderByStockAsc(int stock);

    List<Product> findAllByOrderByNameAsc();
    String getName(int id);
}
