package com.simplilearn.KitchenStory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.KitchenStory.entities.ProductCategory;


public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {

}
