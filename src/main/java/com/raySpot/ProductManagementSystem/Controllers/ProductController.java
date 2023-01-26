package com.raySpot.ProductManagementSystem.Controllers;

import com.raySpot.ProductManagementSystem.models.Product;
import com.raySpot.ProductManagementSystem.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity <Product> createProduct(@RequestBody Product product){
        return ResponseEntity.ok().body(productService.createProduct(product));
    }
//    public String createProduct (@RequestBody Product product){
//        try {
//            productService.createProduct(product);
//            return product + " created successfully";
//        }catch (Exception exception){
//            return "Try another product name";
//        }
//    }

    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable long id, @RequestBody Product product){
        try {
            product.setId(id);
            productService.updateProduct(product);
            return product + " updated successfully";
        }catch (Exception exception){
            return id + " does not exist";
        }
    }
//    public ResponseEntity <Product> updateProduct(@PathVariable long id, @RequestBody Product product){
//        product.setId(id);
//        return ResponseEntity.ok(productService.updateProduct(product));
//    }

    @GetMapping("/allProduct")
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok().body(productService.getAllProduct());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id){
        return ResponseEntity.ok().body(productService.findProductById(id));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id){
        try {
            productService.deleteProduct(id);
            return "product deleted successfully";
        }catch (Exception exception){
            return "Product does not exist";
        }

    }

}
