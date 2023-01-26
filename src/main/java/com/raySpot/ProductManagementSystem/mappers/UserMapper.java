package com.raySpot.ProductManagementSystem.mappers;

import com.raySpot.ProductManagementSystem.dtos.responseDTO.UserDTO;
import com.raySpot.ProductManagementSystem.models.User;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {
    UserDTO userToUserDTO(User user);
    User userDTOToUser(Optional<User> userDTO);
}
