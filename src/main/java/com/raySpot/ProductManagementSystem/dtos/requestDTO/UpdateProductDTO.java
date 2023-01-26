package com.raySpot.ProductManagementSystem.dtos.requestDTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateProductDTO {
    private String name;
    private String description;
}
