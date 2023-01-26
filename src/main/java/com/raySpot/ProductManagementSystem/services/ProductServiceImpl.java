package com.raySpot.ProductManagementSystem.services;

import com.raySpot.ProductManagementSystem.exceptions.ProductManagementSystemException;
import com.raySpot.ProductManagementSystem.exceptions.ProductNotFoundException;
import com.raySpot.ProductManagementSystem.mappers.ProductMapper;
import com.raySpot.ProductManagementSystem.mappers.ProductMapperImpl;
import com.raySpot.ProductManagementSystem.models.Product;
import com.raySpot.ProductManagementSystem.repository.ProductRepository;
import com.raySpot.ProductManagementSystem.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@NoArgsConstructor
//@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    private ProductMapper productMapper = new ProductMapperImpl();

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    @Override
    public Product createProduct(Product product) throws ProductManagementSystemException{
        return productRepository.save(product);
    }

    @Override
    public Product findProductByName(String name) {
        return productRepository.findProductByName(name).orElseThrow(()-> new ProductNotFoundException("Product does not exist"));
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> productInDB = productRepository.findById(product.getId());
        if(productInDB.isPresent()){
            Product updateProduct = productInDB.get();
            updateProduct.setId(product.getId());
            updateProduct.setName(product.getName());
            updateProduct.setDescription(product.getDescription());
            return updateProduct;
        }
        throw new ProductNotFoundException(product.getName() + " does not exist");
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(long productId) {
        Optional<Product> productInDb = productRepository.findById(productId);

        if(productInDb.isPresent()){
            return productInDb.get();
        }
        throw new ProductNotFoundException(productId + " does not exist");
    }

    @Override
    public void deleteProduct(long productId) {
        Optional<Product> productToDelete = productRepository.findById(productId);
        if(productToDelete.isPresent()){
            productRepository.delete(productToDelete.get());
            System.out.println("Product deleted successfully");
        } else {
            throw new ProductNotFoundException("Product does not exist");
        }
    }
}
