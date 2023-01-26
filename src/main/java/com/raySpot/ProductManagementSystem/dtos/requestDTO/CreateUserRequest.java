package com.raySpot.ProductManagementSystem.dtos.requestDTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequest {
    private String userName;
    private String firstName;
    private String password;
}
