package com.simplilearn.KitchenStory.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.KitchenStory.Exceptions.ProductNotFoundException;
import com.simplilearn.KitchenStory.entities.Product;

public interface ProductService {

	Product createProduct(Product product);
	List<Product> getProducts();
	Product getProductById(Long id) throws ProductNotFoundException;
	Product updateProduct(Long id, Product product) throws ProductNotFoundException;
	void deleteProduct(Long id);
}
