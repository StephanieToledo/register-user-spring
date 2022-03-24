package com.register.users.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.register.users.dto.ProductDTO;
import com.register.users.model.Product;
import com.register.users.repository.ProductRepository;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class ProductController {
	
	@Autowired(required=true)
	ProductRepository productRepository;
	
	@GetMapping("/products")
	public List<Product> productList(){
		return productRepository.findAll();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Long id) {
		Optional getProduct = productRepository.findById(id);
		
		ProductDTO productDTO = new ProductDTO();
		
		if(getProduct.isPresent()) {
			Product product = (Product) getProduct.get();
			
			productDTO.setId(product.getId());
			productDTO.setProduct(product.getProduct());
			productDTO.setImage(product.getImage());
			productDTO.setOldPrice(product.getOldPrice());
			productDTO.setPrice(product.getPrice());
			productDTO.setDescription(product.getDescription());
		}
		
		return getProduct.isPresent() ? ResponseEntity.ok(productDTO) : ResponseEntity.notFound().build();
	}
	
	@PostMapping("/products/register")
	public Product productRegister(@RequestBody Product product) {
		Product newProduct = productRepository.save(product);
		return newProduct;
	}
}






