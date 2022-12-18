package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.ProductService;
import com.etiya.ecommercedemopair1.business.constants.Messages;
import com.etiya.ecommercedemopair1.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.customer.GetCustomerResponse;
import com.etiya.ecommercedemopair1.business.dtos.response.product.GetProductResponse;
import com.etiya.ecommercedemopair1.business.dtos.response.product.ListProductResponse;
import com.etiya.ecommercedemopair1.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair1.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.util.messages.MessageService;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair1.entities.concretes.Category;
import com.etiya.ecommercedemopair1.entities.concretes.Product;
import com.etiya.ecommercedemopair1.repository.abstracts.CategoryRepository;
import com.etiya.ecommercedemopair1.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private final ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private final ModelMapperService modelMapperService;
    private MessageService messageService;


    @Override
    public DataResult<List<GetProductResponse>> getAll() {
        List<Product> products = productRepository.findAll();
        List<GetProductResponse> responses = products.stream()
                .map(product -> modelMapperService.getMapperforResponse()
                        .map(product,GetProductResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetProductResponse>>(responses, messageService.getMessage(Messages.AllSuffix.allFetchedFromDatabase));
    }

    @Override
    public DataResult<GetProductResponse> getById(int id) {
        Product product = productRepository.findById(id).orElseThrow();
        GetProductResponse response = modelMapperService.getMapperforResponse().map(product,GetProductResponse.class);
        return new SuccessDataResult<GetProductResponse>(response, messageService.getMessage(Messages.Product.productWasFound));
    }

    @Override
    public DataResult<List<GetProductResponse>> findAllProductsByStockGreaterThanOrderByStockAsc(int stock) {
        List<Product> products = productRepository.findAllProductsByStockGreaterThanOrderByStockAsc(stock);
        checkGreaterThanStock(products);
        List<GetProductResponse> responses = products.stream()
                .map(product -> modelMapperService.getMapperforResponse()
                .map(product,GetProductResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetProductResponse>>(responses,messageService.getMessage(Messages.Product.productGreaterThanStock));
    }



    @Override
    public DataResult<List<GetProductResponse>> findAllByOrderByNameAsc() {
        List<Product> products = productRepository.findAllByOrderByNameAsc();
        List<GetProductResponse> getProductResponses= products.stream()
                .map(product -> modelMapperService.getMapperforResponse()
                .map(product,GetProductResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetProductResponse>>(getProductResponses,messageService.getMessage(Messages.Product.productByName));
    }

    @Override
    public DataResult<GetProductResponse> getByName(String name) {
        Product product = productRepository.findByName(name);
        GetProductResponse getProductResponse = modelMapperService.getMapperforResponse().map(product, GetProductResponse.class);
        return new SuccessDataResult<GetProductResponse>(getProductResponse, Messages.AllSuffix.allFetchedFromDatabase+ "by name");
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
        if(products.size()==0) {

            throw new BusinessException("This category has any product");
        }
        List<GetProductResponse> responses = products.stream()
                .map(product -> modelMapperService.getMapperforResponse()
                        .map(product, GetProductResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetProductResponse>>(responses, Messages.AllSuffix.allFetchedFromDatabase + " by category name");
    }

    @Override
    public DataResult<List<GetProductResponse>> getProductsByCategoryId(int identity) {
       List<GetProductResponse> responses = productRepository.getProductsByCategoryId(identity);

        return new SuccessDataResult<List<GetProductResponse>>(responses, Messages.AllSuffix.allFetchedFromDatabase + "by category id");
    }

    @Override
    public Page<Product> findAllWithPagination(Pageable pageable) {

        return productRepository.findAll(pageable);
    }

    @Override
    public Slice<Product> findAllWithSlice(Pageable pageable) {
        return productRepository.getAllWithSlice(pageable);
    }

 /*   @Override
    public Page<ListProductResponse> getAllWithPagewResponse(Pageable pageable) {
        return productRepository.getAllWithPagewResponse(pageable);
    }*/

    public void checkCategoryWithId(int id) {
        boolean isExists = categoryRepository.existsById(id);
        if (!isExists) {
            throw new BusinessException("This category doesn't exist. Could not be added prod");
        }
    }

    private void checkGreaterThanStock(List<Product> products) {
        if(products.size()==0){
            throw  new BusinessException("There are any products greater than given stock");
        }
    }



}
