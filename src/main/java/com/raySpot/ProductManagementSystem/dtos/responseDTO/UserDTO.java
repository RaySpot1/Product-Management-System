package com.raySpot.ProductManagementSystem.dtos.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String Id;
    private String userName;
    private String firstName;
    private String dateCreated;
}
