package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.category.GetCategoryResponse;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.entities.concretes.Category;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryService {
    DataResult<List<GetCategoryResponse>> getAll();
    DataResult<GetCategoryResponse> getById(int id);
    DataResult<List<GetCategoryResponse>> findAllByName(String name);
    DataResult<List<GetCategoryResponse>>  getCategoryWithIdDesc();
    DataResult<GetCategoryResponse> addCategory(AddCategoryRequest addCategoryRequest);

    DataResult<GetCategoryResponse> addCategoryResponse(AddCategoryRequest addCategoryRequest);

    List<Category> findCategoryByProductStockGraterThan(@Param("stock") int stock);

}
