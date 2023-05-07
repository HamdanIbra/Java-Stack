package com.axsos.ProductsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.axsos.ProductsAndCategories.models.Category;
import com.axsos.ProductsAndCategories.models.Product;


public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
	List<Product> findAllByCategories(Category category);
    
	List<Product> findByCategoriesNotContains(Category c);
}
