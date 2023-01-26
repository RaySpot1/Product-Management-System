//package com.raySpot.ProductManagementSystem.services;
//
//import com.raySpot.ProductManagementSystem.dtos.requestDTO.CreateUserRequest;
//import com.raySpot.ProductManagementSystem.dtos.requestDTO.UpdateUserDTO;
//import com.raySpot.ProductManagementSystem.dtos.responseDTO.UserDTO;
//import com.raySpot.ProductManagementSystem.exceptions.UserNotFoundException;
//import com.raySpot.ProductManagementSystem.models.User;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
//import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
//import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.mockito.ArgumentMatchers.any;
//
//
//@SpringBootTest
//@ImportAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
//class UserServiceImplTest {
//    @Autowired
//    private UserService userService;
//    private CreateUserRequest createUserRequest;
//
//    @BeforeEach
//    void setup(){
//        createUserRequest = CreateUserRequest.builder()
//                .userName("rayspot")
//                .password("password")
//                .build();
//    }
//
//    @Test
//    void createAccountTest(){
//        UserDTO userDTO = userService.createUser(createUserRequest);
//        assertThat(userDTO.getId()).isNotNull();
//        assertThat(userDTO.getUserName()).isEqualTo("rayspot");
//    }
//
//    @Test
//    void exceptionIsThrownWhenUserNameAlreadyExist(){
//        userService.createUser(createUserRequest);
//        CreateUserRequest createUserRequest = CreateUserRequest.builder()
//                .userName("rayspot")
//                .password("password")
//                .build();
//        assertThatThrownBy(()-> userService.createUser(createUserRequest)).isInstanceOf(UserNotFoundException.class).hasMessage("Username already exist");
//    }
//
////    @Test
////    void updateUserTest(){
////        UserDTO userDTO = userService.createUser(createUserRequest);
////        UpdateUserDTO updateUserDTO = new UpdateUserDTO("mrBean", "Bean", "newpassword");
////        String result = userService.updateUser(updateUserDTO);
////        assertThat(result).isEqualTo("User updated successfully");
////        User userFromDB = userService.findUserByUserName(userDTO.getUserName());
////        assertThat(userFromDB).isEqualTo("mrBean");
////
////
////    }
//
//    @Test
//    void searchUserByUserName(){
//        UserDTO userDTO = userService.createUser(createUserRequest);
//        User userFromDB = userService.findUserByUserName(userDTO.getUserName());
//        assertThat(userDTO.getUserName()).isEqualTo(userFromDB.getUserName());
//    }
//
//    @Test
//    void searchUserById(){
//        UserDTO userDTO = userService.createUser(createUserRequest);
//        User userFromDB = userService.findUserById(userDTO.getId());
//        assertThat(userDTO.getId()).isEqualTo(userFromDB.getId());
//    }
//
//    @Test
//    void deleteUser(){
//        userService.deleteUser("rayspot");
//    }
//
////    @AfterEach
////    void tearDown() {
////        userService.deleteUser("rayspot");
////    }
//}