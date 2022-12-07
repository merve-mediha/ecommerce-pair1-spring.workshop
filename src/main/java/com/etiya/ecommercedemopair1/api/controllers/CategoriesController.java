package com.etiya.ecommercedemopair1.api.controllers;

import com.etiya.ecommercedemopair1.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair1.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.category.GetCategoryResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")

public class CategoriesController {

    private CategoryService categoryService;

    @Autowired
    public CategoriesController(CategoryService categoryService) { //Dependency Injection
        this.categoryService = categoryService;
    }

    @GetMapping("/getAll")
    public List<Category> getAll() {
        return this.categoryService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Category getById(@PathVariable int id) {
        return this.categoryService.getById(id);
    }

    @GetMapping("/getByName")
    List<Category> findAllByName(@RequestParam("name") String name) {
        return this.categoryService.findAllByName(name);
    }

    @GetMapping("/getByIdDesc")
    public List<Category> getCategoryWithIdDesc() {
        return this.categoryService.getCategoryWithIdDesc();
    }

    //client
    //server
    //DTO => Data Transfer Object
    //AddCategoryRequest() => name,type
    // JPA Repository save methodu , eklenen veriyi geri döndürür.
    // ResponseEntity

    //  Previous - DTO not used
//    @PostMapping("/add")
//    public void addCategory(@RequestBody Category category) {
//        this.categoryService.addCategory(category);
//    }

    //  Current - DTO used (necessary)
//    @PostMapping("/add")
//    public Category addCategory(@RequestBody AddCategoryRequest addCategoryRequest) {
//        return this.categoryService.addCategory(addCategoryRequest);
//    }


    //  Dto used (necessary) - different version that return 201 status code.
    @PostMapping("/add")
    public ResponseEntity<GetCategoryResponse> addCategory(@RequestBody AddCategoryRequest addCategoryRequest) {
        return new ResponseEntity<GetCategoryResponse>(categoryService.addCategory(addCategoryRequest), HttpStatus.CREATED);
    }


}
