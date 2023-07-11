package com.simplilearn.KitchenStory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.KitchenStory.entities.Product;
import com.simplilearn.KitchenStory.entities.ProductCategory;
import com.simplilearn.KitchenStory.service.CategoryService;
import com.simplilearn.KitchenStory.service.ProductService;

@RestController
@RequestMapping("/api")
public class AdminController {
	
	private ProductService productService;
	private CategoryService categoryService;
	
	@Autowired
	public AdminController(ProductService productService, CategoryService categoryService) {
		
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	//Products
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product){ //@RequestBody - so that whatever data coming from
		                                                               //               client side should be binded with Product object
		
		Product p = productService.createProduct(product);
		
		return p;
		
	}
	
	@GetMapping("/getProducts")
	public List<Product> getAllProducts(){
		return productService.getProducts();
		
	}
	
	@DeleteMapping("/deleteProduct/{pid}")
	public void deleteProduct(@PathVariable Long pid){
		
		productService.deleteProduct(pid);
		
	}
	//Categories
	
	@PostMapping("/addCategory")
	public ProductCategory addCategory(@RequestBody ProductCategory category){ //@RequestBody - so that whatever data coming from
		                                                               //               client side should be binded with Product object
		
		ProductCategory c = categoryService.createCategory(category);
		
		return c;
		
	}
	
	@GetMapping("/getCategories")
	public List<ProductCategory> getAllCategories(){
		return categoryService.getCategories();
		
	}
	
	

}
