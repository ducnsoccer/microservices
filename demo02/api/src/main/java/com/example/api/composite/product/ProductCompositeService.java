package com.example.api.composite.product;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import reactor.core.publisher.Mono;

public interface ProductCompositeService {
	
	@PostMapping(value = "/product-composite", consumes = "application/json")
	Mono<Void> createCompositeProduct(@RequestBody ProductAggregate body);

	@GetMapping(value = "/product-composite/{productId}", produces = "application/json")
	Mono<ProductAggregate> getCompositeProduct(@PathVariable int productId);
	
    @DeleteMapping(value = "/product-composite/{productId}")
    Mono<Void> deleteCompositeProduct(@PathVariable int productId);
}
