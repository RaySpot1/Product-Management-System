package com.raySpot.ProductManagementSystem.mappers;

import com.raySpot.ProductManagementSystem.dtos.responseDTO.ProductDTO;
import com.raySpot.ProductManagementSystem.dtos.responseDTO.UserDTO;
import com.raySpot.ProductManagementSystem.models.Product;
import com.raySpot.ProductManagementSystem.models.User;

public class ProductMapperImpl implements ProductMapper{
    @Override
    public ProductDTO productToProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());

        return productDTO;
    }

    @Override
    public Product productDTOToProduct(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());


        return product;
    }
}
