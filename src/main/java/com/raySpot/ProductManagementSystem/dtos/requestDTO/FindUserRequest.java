package com.raySpot.ProductManagementSystem.dtos.requestDTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindUserRequest {
    public String userName;
    public String firstName;
}
