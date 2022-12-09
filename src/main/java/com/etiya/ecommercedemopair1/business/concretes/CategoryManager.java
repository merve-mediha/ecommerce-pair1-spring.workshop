package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair1.business.constants.Messages;
import com.etiya.ecommercedemopair1.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.category.GetCategoryResponse;
import com.etiya.ecommercedemopair1.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair1.entities.concretes.Category;
import com.etiya.ecommercedemopair1.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    private CategoryRepository categoryRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetCategoryResponse>> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<GetCategoryResponse> responses = categories.stream().map(category -> modelMapperService.getMapperforResponse().map(category, GetCategoryResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetCategoryResponse>>(responses, Messages.AllSuffix.getAllSuffixOfMessages);
    }

    @Override
    public DataResult<GetCategoryResponse> getById(int id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        GetCategoryResponse response = modelMapperService.getMapperforResponse().map(category, GetCategoryResponse.class);
        return new SuccessDataResult<GetCategoryResponse>(response, Messages.AllSuffix.getByIdSuffixOfMessages);
    }

    @Override
    public DataResult<List<GetCategoryResponse>> findAllByName(String name) {
        List<Category> categories = categoryRepository.findAllByName(name);
        List<GetCategoryResponse> responses = categories.stream().map(category -> modelMapperService.getMapperforResponse().map(category, GetCategoryResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetCategoryResponse>>(responses, Messages.AllSuffix.getAllSuffixOfMessages);
    }

    @Override
    public DataResult<List<GetCategoryResponse>> getCategoryWithIdDesc() {
        List<Category> categories = categoryRepository.findAll();
        List<GetCategoryResponse> responses = categories.stream().map(category -> modelMapperService.getMapperforResponse().map(category, GetCategoryResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetCategoryResponse>>(responses, Messages.AllSuffix.getAllSuffixOfMessages);
    }


    public DataResult<GetCategoryResponse> addCategory(AddCategoryRequest addCategoryRequest) {
        // MappingCategory
        //  Mapping: AUTO MAPPER
     /*  --->Manuel mapping
      Category category = new Category();
      category.setName(addCategoryRequest.getName());
      */

        Category category = modelMapperService.getMapperforRequest().map(addCategoryRequest, Category.class);
        checkCategoryNameExists(category);
        Category savedCategory = this.categoryRepository.save(category);


        //Mapping => Category => AddCategoryResponse
        /*GetCategoryResponse response =
                new GetCategoryResponse(savedCategory.getId(), savedCategory.getName());
        */
        GetCategoryResponse response = modelMapperService.getMapperforResponse().map(savedCategory, GetCategoryResponse.class);

        return new SuccessDataResult<GetCategoryResponse>(response, Messages.AllSuffix.addSuffixOfMessages);
    }

    @Override
    public DataResult<GetCategoryResponse> addCategoryResponse(AddCategoryRequest addCategoryRequest) {

        Category category = modelMapperService.getMapperforRequest().map(addCategoryRequest,Category.class);

        checkCategoryNameExists(category);
        Category savedCategory = this.categoryRepository.save(category);

        GetCategoryResponse getCategoryResponse = modelMapperService.getMapperforResponse().map(savedCategory, GetCategoryResponse.class);
        return new SuccessDataResult<GetCategoryResponse>(getCategoryResponse, Messages.AllSuffix.addSuffixOfMessages);

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