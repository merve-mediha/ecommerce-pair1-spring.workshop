package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.product.GetProductResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Product;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(int id);

    List<Product> findAllProductsByStockGreaterThanOrderByStockAsc(int stock);

    List<Product> findAllByOrderByNameAsc();
    Product getByName(String name);
    String getProductNameWithId(int id);

    GetProductResponse addProduct(AddProductRequest addProductRequest);

    List<Product> findProductByCategoryByName(String name);

    List<GetProductResponse> getProductsByCategoryId(int identity);

}
