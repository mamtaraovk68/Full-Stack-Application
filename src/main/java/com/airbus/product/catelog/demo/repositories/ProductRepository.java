package com.airbus.product.catelog.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.airbus.product.catelog.demo.models.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	
	List<Product> findAll();
	
	List<Product> findAllByProductCategory(String productcategory);
	
	Product save(Product product);

	Optional<Product> findAllByProductId(String productId);
	
	void deleteByProductId(String id);
	
	
	
	
}
