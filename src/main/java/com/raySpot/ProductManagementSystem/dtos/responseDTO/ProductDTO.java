package com.raySpot.ProductManagementSystem.dtos.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private long Id;
    private String name;
    private String description;
    private LocalDateTime dateCreated;
}
