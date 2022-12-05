package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category getById(int id);
    List<Category> findAllByName(String name);
    List<Category> getCategoryWithIdDesc();
}
