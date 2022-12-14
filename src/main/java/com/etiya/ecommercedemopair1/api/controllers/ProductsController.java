package com.etiya.ecommercedemopair1.api.controllers;


import com.etiya.ecommercedemopair1.business.abstracts.ProductService;

import com.etiya.ecommercedemopair1.business.constants.Paths;
import com.etiya.ecommercedemopair1.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.product.GetProductResponse;
import com.etiya.ecommercedemopair1.business.dtos.response.product.ListProductResponse;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.entities.concretes.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix +"products")
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/getAll")
    public DataResult<List<GetProductResponse>> getAll() {
        return productService.getAll();
    }

    @GetMapping("/getById/{id}")
    public DataResult<GetProductResponse> getById(@PathVariable int id) {
        return productService.getById(id);
    }

    @GetMapping("/getAllProductsByStockGreaterThan")
    public DataResult<List<GetProductResponse>> findAllProductsByStockGreaterThanOrderByStockAsc(@RequestParam int stock) {

        return productService.findAllProductsByStockGreaterThanOrderByStockAsc(stock);
    }
    @GetMapping("/getByName")
    public DataResult<GetProductResponse> getByName(@RequestParam("name") String name) {
        return productService.getByName(name);
    }

    @GetMapping("/getAlphabeticProduct")
    public DataResult<List<GetProductResponse>> findAllByOrderByNameAsc() {
        return this.productService.findAllByOrderByNameAsc();
    }

    @GetMapping("/getProductNameWithId/{id}")
    public String getProductNameWithId(@PathVariable int id) {
        return this.productService.getProductNameWithId(id);
    }

    @PostMapping("/add")
    public DataResult<GetProductResponse> addProduct(@RequestBody @Valid AddProductRequest addProductRequest) {
        return productService.addProduct(addProductRequest);
    }

    @PostMapping("/adddone")
    public ResponseEntity<DataResult<GetProductResponse>> addProductOne(@RequestBody AddProductRequest addProductRequest) {
        return new ResponseEntity<DataResult<GetProductResponse>>(productService.addProduct(addProductRequest), HttpStatus.CREATED);
    }

    @GetMapping("/findByCategoryName")
    public DataResult<List<GetProductResponse>> findProductByCategoryByName(@RequestParam("name") String name){
        return productService.findProductByCategoryByName(name);
    }

    @GetMapping("getProductsByCategory")
    public DataResult<List<GetProductResponse>> getProductsByCategoryId(int identity){
        return productService.getProductsByCategoryId(identity);
    }

    @GetMapping("/getWithPagination")
    public Page<Product> findAllWithPagination(@RequestParam("page")int page, @RequestParam("pageSize")int pageSize){
        Pageable pageable = PageRequest.of(page, pageSize);
        return  productService.findAllWithPagination(pageable);
    }

    @GetMapping("/getWithSlice")
    public Slice<Product> findAllWithSlice(@RequestParam("page")int page, @RequestParam("pageSize")int pageSize){
        Pageable pageable = PageRequest.of(page, pageSize);
        return  productService.findAllWithSlice(pageable);
    }
 /*   @GetMapping("/getWithPagewResponse")
    public Page<ListProductResponse> getAllWithPagewResponse(@RequestParam("page")int page, @RequestParam("pageSize")int pageSize){
        Pageable pageable = PageRequest.of(page, pageSize);
        return  productService.getAllWithPagewResponse(p);
    }*/
}
