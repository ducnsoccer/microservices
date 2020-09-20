package com.example.api.composite.product;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProductCompositeService {
	
	@PostMapping(value = "/product-composite", consumes = "application/json")
	void createCompositeProduct(@RequestBody ProductAggregate body);

	@GetMapping(value = "/product-composite/{productId}", produces = "application/json")
	ProductAggregate getCompositeProduct(@PathVariable int productId);
	
    @DeleteMapping(value = "/product-composite/{productId}")
    void deleteCompositeProduct(@PathVariable int productId);
}
