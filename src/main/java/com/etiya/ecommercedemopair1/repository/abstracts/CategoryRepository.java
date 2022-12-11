package com.etiya.ecommercedemopair1.repository.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.response.category.GetCategoryResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Category;
import com.etiya.ecommercedemopair1.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByName(String name);
    @Query("select c from Category c order by c.id desc")
    List<Category> getCategoryWithIdDesc();


    List<Category> findAll();

    @Query("select distinct c from Category c JOIN c.productCategories pc JOIN pc.product p where p.stock>(:stock)")
    List<Category> findCategoryByProductStockGraterThan(@Param("stock") int stock);

}
