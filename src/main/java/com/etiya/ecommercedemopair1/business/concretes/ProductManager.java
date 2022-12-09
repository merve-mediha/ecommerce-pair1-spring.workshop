package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.ProductService;
import com.etiya.ecommercedemopair1.business.constants.Messages;
import com.etiya.ecommercedemopair1.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.customer.GetCustomerResponse;
import com.etiya.ecommercedemopair1.business.dtos.response.product.GetProductResponse;
import com.etiya.ecommercedemopair1.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair1.entities.concretes.Category;
import com.etiya.ecommercedemopair1.entities.concretes.Product;
import com.etiya.ecommercedemopair1.repository.abstracts.CategoryRepository;
import com.etiya.ecommercedemopair1.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public DataResult<List<Product>> findAllProductsByStockGreaterThanOrderByStockAsc(int stock) {
        return new SuccessDataResult<>(Messages.AllSuffix.getAllSuffixOfMessages + "by stock");
    }

    @Override
    public DataResult<List<Product>> findAllByOrderByNameAsc() {
        return new SuccessDataResult<>(Messages.AllSuffix.getAllSuffixOfMessages + "by name alphabetically");
    }

    @Override
    public DataResult<GetProductResponse> getByName(String name) {
        Product product = productRepository.findByName(name);
        GetProductResponse getProductResponse = modelMapperService.getMapperforResponse().map(product, GetProductResponse.class);
        return new SuccessDataResult<GetProductResponse>(getProductResponse, Messages.AllSuffix.getAllSuffixOfMessages+ "by name");
    }
    @Override
    public String getProductNameWithId(int id) {
        return productRepository.getProductNameWithId(id);
    }

    @Override
    public DataResult<GetProductResponse> addProduct(AddProductRequest addProductRequest) {

        // Mapping
        Product product = modelMapperService.getMapperforRequest().map(addProductRequest,Product.class);

        Category category = new Category();


        checkCategoryWithId(addProductRequest.getCategoryId());
        category.setId(addProductRequest.getCategoryId());

        Product savedProduct = productRepository.save(product);


        GetProductResponse getProductResponse = modelMapperService.getMapperforResponse().map(savedProduct,GetProductResponse.class);

        return new SuccessDataResult<GetProductResponse>(getProductResponse,Messages.AllSuffix.addSuffixOfMessages);
    }

    @Override
    public DataResult<List<GetProductResponse>> findProductByCategoryByName(String name) {
        List<Product> products = productRepository.findProductByCategoryByName(name);
        List<GetProductResponse> responses = products.stream()
                .map(product -> modelMapperService.getMapperforResponse()
                        .map(product, GetProductResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetProductResponse>>(responses, Messages.AllSuffix.getAllSuffixOfMessages + " by category name");
    }

    @Override
    public DataResult<List<GetProductResponse>> getProductsByCategoryId(int identity) {
       List<GetProductResponse> responses = productRepository.getProductsByCategoryId(identity);

        return new SuccessDataResult<List<GetProductResponse>>(responses, Messages.AllSuffix.getAllSuffixOfMessages + "by category id");
    }

    public void checkCategoryWithId(int id) {
        boolean isExists = categoryRepository.existsById(id);
        if (!isExists) {
            throw new RuntimeException("This category doesn't exist. Could not be added prod");
        }
    }



}
