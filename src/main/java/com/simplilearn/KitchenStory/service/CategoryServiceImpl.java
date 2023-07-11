package com.simplilearn.KitchenStory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.KitchenStory.Exceptions.CategoryNotFoundException;
import com.simplilearn.KitchenStory.Exceptions.ProductNotFoundException;
import com.simplilearn.KitchenStory.Repository.ProductCategoryRepository;
import com.simplilearn.KitchenStory.entities.Product;
import com.simplilearn.KitchenStory.entities.ProductCategory;

@Service
public class CategoryServiceImpl implements CategoryService {

	private ProductCategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServiceImpl(ProductCategoryRepository categoryRepository) {
		
		this.categoryRepository = categoryRepository;
	}

	@Override
	public ProductCategory createCategory(ProductCategory category) {
		
		return categoryRepository.save(category);
	}

	@Override
	public List<ProductCategory> getCategories() {
		
		List<ProductCategory> categories = categoryRepository.findAll();
		return categories;
	}

	@Override
	public ProductCategory getCategoryById(Long id) throws ProductNotFoundException, CategoryNotFoundException {
		
		ProductCategory c = null;
		Optional<ProductCategory> category = categoryRepository.findById(id);
		
		if(category.isPresent()) {
			
			c= category.get();
		}else {
			
			throw new CategoryNotFoundException("Category with given id not found");
			
		}
		return c;
	}

	@Override
	public ProductCategory updateCategory(Long id, ProductCategory category) throws ProductNotFoundException, CategoryNotFoundException {
		
		ProductCategory c = getCategoryById(id);  //Using previous method to get category
		
		c.setCategoryName(category.getCategoryName());
		c.setProducts(category.getProducts());
		
		
		categoryRepository.save(c);
		
		return c;
	}

	@Override
	public void deleteCategory(Long id) {
		
		categoryRepository.deleteById(id);
		
	}

}
