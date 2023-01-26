package com.raySpot.ProductManagementSystem.dtos.requestDTO;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProductRequest {
//    @Id
//    private String Id;
    private String name;
    private String description;
}
