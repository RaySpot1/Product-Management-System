package com.raySpot.ProductManagementSystem.services;

import com.raySpot.ProductManagementSystem.dtos.requestDTO.CreateUserRequest;
import com.raySpot.ProductManagementSystem.dtos.requestDTO.UpdateUserDTO;
import com.raySpot.ProductManagementSystem.dtos.responseDTO.UserDTO;
import com.raySpot.ProductManagementSystem.models.Product;
import com.raySpot.ProductManagementSystem.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDTO createUser(CreateUserRequest userRequestDto);

    String updateUser(UpdateUserDTO updateUserDTO);

    List<User> getAllUser();

    User findUserByUserName(String userName);

    User findUserByFirstName(String firstName);

//    Product createProduct(String product);

    User findUserById(String id);

    Object deleteUser(String userName);
}
