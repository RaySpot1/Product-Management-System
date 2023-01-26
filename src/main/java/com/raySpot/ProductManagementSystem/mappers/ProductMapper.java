package com.raySpot.ProductManagementSystem.mappers;

import com.raySpot.ProductManagementSystem.dtos.responseDTO.ProductDTO;
import com.raySpot.ProductManagementSystem.models.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductDTO productToProductDTO(Product product);
    Product productDTOToProduct(ProductDTO productDTO);
}
