package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.product.GetProductResponse;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.entities.concretes.Product;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductService {
    DataResult<List<GetProductResponse>> getAll();
    DataResult<GetProductResponse> getById(int id);

    DataResult<List<GetProductResponse>> findAllProductsByStockGreaterThanOrderByStockAsc(int stock);

    DataResult<List<GetProductResponse>> findAllByOrderByNameAsc();
    DataResult<GetProductResponse> getByName(String name);
    String getProductNameWithId(int id);

    DataResult<GetProductResponse> addProduct(AddProductRequest addProductRequest);

    DataResult<List<GetProductResponse>> findProductByCategoryByName(String name);

    DataResult<List<GetProductResponse>> getProductsByCategoryId(int identity);

}
