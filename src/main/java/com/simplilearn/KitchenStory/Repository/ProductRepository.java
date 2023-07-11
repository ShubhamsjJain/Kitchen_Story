package com.simplilearn.KitchenStory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.KitchenStory.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
