package com.etiya.ecommercedemopair1.api.controllers;


import com.etiya.ecommercedemopair1.business.abstracts.ProductService;

import com.etiya.ecommercedemopair1.business.constants.Paths;
import com.etiya.ecommercedemopair1.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.product.GetProductResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Product;

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
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Product getById(@PathVariable int id) {
        return productService.getById(id);
    }

    @GetMapping("/getAllProductsByStockGreaterThan")
    public List<Product> findAllProductsByStockGreaterThanOrderByStockAsc(@RequestParam int stock) {

        return productService.findAllProductsByStockGreaterThanOrderByStockAsc(stock);
    }
    @GetMapping("/getByName")
    public Product getByName(@RequestParam("name") String name) {
        return productService.getByName(name);
    }

    @GetMapping("/getAlphabeticProduct")
    public List<Product> findAllByOrderByNameAsc() {
        return this.productService.findAllByOrderByNameAsc();
    }

    @GetMapping("/getProductNameWithId/{id}")
    public String getProductNameWithId(@PathVariable int id) {
        return this.productService.getProductNameWithId(id);
    }

    @PostMapping("/add")
    public GetProductResponse addProduct(@RequestBody @Valid AddProductRequest addProductRequest) {
        return productService.addProduct(addProductRequest);
    }

    @PostMapping("/adddone")
    public ResponseEntity<GetProductResponse> addProductOne(@RequestBody AddProductRequest addProductRequest) {
        return new ResponseEntity<GetProductResponse>(productService.addProduct(addProductRequest), HttpStatus.CREATED);
    }

    @GetMapping("/findByCategoryName")
    public List<Product> findProductByCategoryByName(@RequestParam("name") String name){
        return productService.findProductByCategoryByName(name);
    }

    @GetMapping("getProductsByCategory")
    public List<GetProductResponse> getProductsByCategoryId(int identity){
        return productService.getProductsByCategoryId(identity);
    }


}
