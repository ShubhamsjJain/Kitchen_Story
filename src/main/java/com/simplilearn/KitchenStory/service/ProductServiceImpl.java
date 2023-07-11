package com.simplilearn.KitchenStory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.KitchenStory.Exceptions.ProductNotFoundException;
import com.simplilearn.KitchenStory.Repository.ProductCategoryRepository;
import com.simplilearn.KitchenStory.Repository.ProductRepository;
import com.simplilearn.KitchenStory.entities.Product;
import com.simplilearn.KitchenStory.entities.ProductCategory;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	//private ProductCategoryRepository categoryRepository;
	//private CategoryServiceImpl categoryServiceImpl;
	
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository, ProductCategoryRepository categoryRepository,CategoryServiceImpl categoryServiceImpl ) {
		
		this.productRepository = productRepository;
		//this.categoryRepository = categoryRepository;
		//this.categoryServiceImpl = categoryServiceImpl;
	}

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
		
	}

	@Override
	public List<Product> getProducts() {
		
		List<Product> products = productRepository.findAll();
		return products;
	}

	@Override
	public Product getProductById(Long id) throws ProductNotFoundException {
		
		Product p = null;
		Optional<Product> product = productRepository.findById(id);
		
		if(product.isPresent()) {
			
			p= product.get();
		}else {
			
			throw new ProductNotFoundException("Product with given id not found");
			
		}
		return p;
	}

	@Override
	public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
		
		Product p = getProductById(id);  //Using previous method to get product
		
		p.setName(product.getName());
		p.setSku(product.getSku());
		p.setDescription(product.getDescription());
		p.setPrice(product.getPrice());
		p.setImageUrl(product.getImageUrl());
		//p.setAvailable(product.isAvailable());
		p.setUnitsInStock(product.getUnitsInStock());
		p.setDateCreated(product.getDateCreated());
		p.setLastUpdated(product.getLastUpdated());
		p.setCategory(product.getCategory());
		
		productRepository.save(p);
		
		return p;
	}

	@Override
	public void deleteProduct(Long id) {
		
		productRepository.deleteById(id);
		
	}

}
