package com.raySpot.ProductManagementSystem.repository;

import com.raySpot.ProductManagementSystem.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface ProductRepository extends MongoRepository<Product, Long> {
    Optional<Product> findProductByName(String name);
}
