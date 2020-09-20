package com.example.microservices.composite.product;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.CompositeReactiveHealthIndicator;
import org.springframework.boot.actuate.health.DefaultReactiveHealthIndicatorRegistry;
import org.springframework.boot.actuate.health.HealthAggregator;
import org.springframework.boot.actuate.health.ReactiveHealthIndicator;
import org.springframework.boot.actuate.health.ReactiveHealthIndicatorRegistry;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.microservices.composite.product.services.ProductCompositeIntegration;

@SpringBootApplication
@ComponentScan("com.example")
public class ProductCompositeServiceApplication {

	@Autowired
	HealthAggregator healthAggregator;

	@Autowired
	ProductCompositeIntegration integration;

	@Bean
	ReactiveHealthIndicator coreServices() {

		ReactiveHealthIndicatorRegistry registry = new DefaultReactiveHealthIndicatorRegistry(new LinkedHashMap<>());

		registry.register("product", () -> integration.getProductHealth());
		registry.register("recommendation", () -> integration.getRecommendationHealth());
		registry.register("review", () -> integration.getReviewHealth());

		return new CompositeReactiveHealthIndicator(healthAggregator, registry);
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductCompositeServiceApplication.class, args);
	}
}
