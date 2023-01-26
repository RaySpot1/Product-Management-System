package com.raySpot.ProductManagementSystem.mappers;

import com.raySpot.ProductManagementSystem.dtos.responseDTO.UserDTO;
import com.raySpot.ProductManagementSystem.models.User;

import java.util.Optional;

public class UserMapperImpl implements UserMapper {
    @Override
    public UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setUserName( user.getUserName() );

        return userDTO;
    }

    @Override
    public User userDTOToUser(Optional<User> userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( user.getId() );
        user.setUserName( user.getUserName());

        return user;
    }
}
