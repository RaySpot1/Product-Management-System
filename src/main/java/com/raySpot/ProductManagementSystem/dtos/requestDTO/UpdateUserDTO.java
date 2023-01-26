package com.raySpot.ProductManagementSystem.dtos.requestDTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserDTO {
    private String userName;
    private String firstName;
    private String password;

}
