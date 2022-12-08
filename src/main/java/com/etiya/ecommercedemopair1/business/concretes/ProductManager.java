package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.ProductService;
import com.etiya.ecommercedemopair1.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.product.GetProductResponse;
import com.etiya.ecommercedemopair1.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.entities.concretes.Category;
import com.etiya.ecommercedemopair1.entities.concretes.Product;
import com.etiya.ecommercedemopair1.repository.abstracts.CategoryRepository;
import com.etiya.ecommercedemopair1.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private final ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private final ModelMapperService modelMapperService;


    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Product> findAllProductsByStockGreaterThanOrderByStockAsc(int stock) {
        return productRepository.findAllProductsByStockGreaterThanOrderByStockAsc(stock);
    }

    @Override
    public List<Product> findAllByOrderByNameAsc() {
        return productRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Product getByName(String name) {
        return productRepository.findByName(name);
    }
    @Override
    public String getProductNameWithId(int id) {
        return productRepository.getProductNameWithId(id);
    }

    @Override
    public GetProductResponse addProduct(AddProductRequest addProductRequest) {

        // Mapping
        Product product = modelMapperService.getMapperforRequest().map(addProductRequest,Product.class);

        Category category = new Category();


        checkCategoryWithId(addProductRequest.getCategoryId());
        category.setId(addProductRequest.getCategoryId());

        Product savedProduct = productRepository.save(product);


        GetProductResponse getProductResponse = modelMapperService.getMapperforResponse().map(savedProduct,GetProductResponse.class);

        return getProductResponse;
    }

    @Override
    public List<Product> findProductByCategoryByName(String name) {
        return productRepository.findProductByCategoryByName(name);
    }

    public void checkCategoryWithId(int id) {
        boolean isExists = categoryRepository.existsById(id);
        if (!isExists) {
            throw new RuntimeException("This category doesn't exist. Could not be added prod");
        }
    }

}
