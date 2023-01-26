package com.raySpot.ProductManagementSystem.dtos.requestDTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteUserRequest {
    private String userName;
}
