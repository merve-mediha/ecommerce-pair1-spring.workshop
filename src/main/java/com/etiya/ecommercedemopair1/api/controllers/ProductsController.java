package com.etiya.ecommercedemopair1.api.controllers;


import com.etiya.ecommercedemopair1.business.abstracts.ProductService;

import com.etiya.ecommercedemopair1.entities.concretes.Product;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
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
    public List<Product> indAllProductsByStockGreaterThanOrderByStockAsc(@RequestParam int stock) {

        return productService.findAllProductsByStockGreaterThanOrderByStockAsc(stock);
    }


}
