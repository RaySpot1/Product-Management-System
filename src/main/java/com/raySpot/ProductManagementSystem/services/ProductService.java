package com.raySpot.ProductManagementSystem.services;

import com.raySpot.ProductManagementSystem.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService{
    Product createProduct(Product product);

    Product updateProduct(Product product);

    Product findProductByName(String name);

    List<Product> getAllProduct();

    Product findProductById(long productId);

    void deleteProduct(long productId);
}
