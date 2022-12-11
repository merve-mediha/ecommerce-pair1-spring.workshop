package com.etiya.ecommercedemopair1.api.controllers;

import com.etiya.ecommercedemopair1.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair1.business.constants.Paths;
import com.etiya.ecommercedemopair1.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.category.GetCategoryResponse;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.entities.concretes.Category;
import com.etiya.ecommercedemopair1.repository.abstracts.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix +"categories")

public class CategoriesController {

    private CategoryService categoryService;
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoriesController(CategoryService categoryService,
                                CategoryRepository categoryRepository) { //Dependency Injection
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/getAll")
    public DataResult<List<GetCategoryResponse>> getAll() {
        return this.categoryService.getAll();
    }

    @GetMapping("/getById/{id}")
    public DataResult<GetCategoryResponse> getById(@PathVariable int id) {
        return this.categoryService.getById(id);
    }

    @GetMapping("/getByName")
    public DataResult<List<GetCategoryResponse>> findAllByName(@RequestParam("name") String name) {
        return this.categoryService.findAllByName(name);
    }

    @GetMapping("/getByIdDesc")
    public DataResult<List<GetCategoryResponse>> getCategoryWithIdDesc() {
        return this.categoryService.getCategoryWithIdDesc();
    }

    @GetMapping("/findCategoryByProductStockGraterThan")
    public List<Category> findCategoryByProductStockGraterThan(@Param("stock") int stock){
        return categoryRepository.findCategoryByProductStockGraterThan(stock);
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
    public ResponseEntity<DataResult<GetCategoryResponse>> addCategory(@RequestBody AddCategoryRequest addCategoryRequest) {
        return new ResponseEntity<DataResult<GetCategoryResponse>>(categoryService.addCategory(addCategoryRequest), HttpStatus.CREATED);
    }


}
