package com.simplilearn.KitchenStory.service;

import java.util.List;

import com.simplilearn.KitchenStory.Exceptions.CategoryNotFoundException;
import com.simplilearn.KitchenStory.Exceptions.ProductNotFoundException;
import com.simplilearn.KitchenStory.entities.ProductCategory;

public interface CategoryService {

	
		ProductCategory createCategory(ProductCategory category);
		List<ProductCategory> getCategories();
		ProductCategory getCategoryById(Long id) throws ProductNotFoundException, CategoryNotFoundException;
		ProductCategory updateCategory(Long id, ProductCategory category) throws ProductNotFoundException, CategoryNotFoundException;
		void deleteCategory(Long id);	
		
	
}
