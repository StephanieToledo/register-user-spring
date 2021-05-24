package com.register.users.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.register.users.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findAll();
	Optional findById(long id);
	Product findByPrice(String price);
	Product findByProduct(String product);
}
