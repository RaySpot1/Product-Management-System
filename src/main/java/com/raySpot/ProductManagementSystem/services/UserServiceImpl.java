package com.raySpot.ProductManagementSystem.services;

import com.raySpot.ProductManagementSystem.dtos.requestDTO.CreateProductRequest;
import com.raySpot.ProductManagementSystem.dtos.requestDTO.CreateUserRequest;
import com.raySpot.ProductManagementSystem.dtos.requestDTO.UpdateUserDTO;
import com.raySpot.ProductManagementSystem.dtos.responseDTO.UserDTO;
import com.raySpot.ProductManagementSystem.exceptions.ProductManagementSystemException;
import com.raySpot.ProductManagementSystem.exceptions.UserNotFoundException;
import com.raySpot.ProductManagementSystem.mappers.UserMapper;
import com.raySpot.ProductManagementSystem.mappers.UserMapperImpl;
import com.raySpot.ProductManagementSystem.models.Product;
import com.raySpot.ProductManagementSystem.models.User;
import com.raySpot.ProductManagementSystem.repository.ProductRepository;
import com.raySpot.ProductManagementSystem.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
//@AllArgsConstructor
@Validated
@Repository
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    private UserMapper userMapper = new UserMapperImpl();

//    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public void ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public UserDTO createUser(CreateUserRequest userRequestDto) throws ProductManagementSystemException {
        Optional<User> optionalUser = userRepository.findUserByUserName(userRequestDto.getUserName());
        if(optionalUser.isEmpty()){
            User user = new User();
            user.setUserName(userRequestDto.getUserName());
            user.setFirstName(userRequestDto.getFirstName());
            user.setPassword(userRequestDto.getPassword());
//            user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
            user.setLocalDateTime(LocalDateTime.now());
            User createdUser = userRepository.save(user);
            return userMapper.userToUserDTO(createdUser);
        }
        throw new ProductManagementSystemException("Username already exist");
    }

    @Override
    public String updateUser(UpdateUserDTO updateUserDTO) {
        User user = userRepository.findUserByUserName(updateUserDTO.getUserName()).orElseThrow(()-> new UserNotFoundException("User does not exist"));
        boolean isUpdated = false;

        if(!(updateUserDTO.getUserName() == null || updateUserDTO.getUserName().trim().equals(""))){
            user.setUserName(updateUserDTO.getUserName());
            isUpdated = true;
        }

        if(!(updateUserDTO.getFirstName() == null || updateUserDTO.getFirstName().trim().equals(""))){
            user.setFirstName(updateUserDTO.getFirstName());
            isUpdated = true;
        }

        if(!(updateUserDTO.getPassword() == null || updateUserDTO.getPassword().trim().equals(""))){
            user.setPassword(updateUserDTO.getPassword());
            isUpdated = true;
        }

        if(isUpdated){
            userRepository.save(user);
        }
        return "User updated successfully";
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findUserByUserName(userName).orElseThrow(()-> new UserNotFoundException(userName + " does not match records"));
    }

    @Override
    public User findUserByFirstName(String firstName) {
        return userRepository.findUserByFirstName(firstName).orElseThrow(()-> new UserNotFoundException(firstName + " does not exist"));
    }

    @Override
    public User findUserById(String id) {
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User does not exist"));
    } //todo

    @Override
    public Object deleteUser(String userName) {
        userRepository.delete(findUserByUserName(userName));
        return null;
    }

    @Override
    public Product createProduct(String product){
        Optional<Product> optionalProduct = productRepository.findProductByName(CreateProductRequest.);

    }
}


