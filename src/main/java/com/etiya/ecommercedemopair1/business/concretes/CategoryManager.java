package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair1.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.category.GetCategoryResponse;
import com.etiya.ecommercedemopair1.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.entities.concretes.Category;
import com.etiya.ecommercedemopair1.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    private CategoryRepository categoryRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category getById(int id) {
        return this.categoryRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Category> findAllByName(String name) {
        return this.categoryRepository.findAllByName(name);
    }

    @Override
    public List<Category> getCategoryWithIdDesc() {
        return this.categoryRepository.getCategoryWithIdDesc();
    }


    public GetCategoryResponse addCategory(AddCategoryRequest addCategoryRequest) {
        // MappingCategory
        //  Mapping: AUTO MAPPER
     /*  --->Manuel mapping
      Category category = new Category();
      category.setName(addCategoryRequest.getName());
      */

        Category category = modelMapperService.getMapperforRequest().map(addCategoryRequest,Category.class);
        checkCategoryNameExists(category);
        Category savedCategory = this.categoryRepository.save(category);



        //Mapping => Category => AddCategoryResponse
        /*GetCategoryResponse response =
                new GetCategoryResponse(savedCategory.getId(), savedCategory.getName());
        */
        GetCategoryResponse response = modelMapperService.getMapperforResponse().map(savedCategory, GetCategoryResponse.class);
        return response;

    }

    @Override
    public GetCategoryResponse getCategoryResponse(AddCategoryRequest addCategoryRequest) {

        Category category = modelMapperService.getMapperforRequest().map(addCategoryRequest,Category.class);

        checkCategoryNameExists(category);
        Category savedCategory = this.categoryRepository.save(category);

        GetCategoryResponse getCategoryResponse = modelMapperService.getMapperforResponse().map(savedCategory, GetCategoryResponse.class);
        return getCategoryResponse;

    }

    private void checkCategoryNameExists(Category category) {
        List<Category> categories = categoryRepository.findAll();

        for (Category secondCategory : categories) {
            if (secondCategory.getName().equals(category.getName())) {
                throw new RuntimeException("This category already exists");
            }
        }
    }
}