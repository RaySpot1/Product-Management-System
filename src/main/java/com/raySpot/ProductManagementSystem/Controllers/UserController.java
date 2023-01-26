package com.raySpot.ProductManagementSystem.Controllers;

import com.raySpot.ProductManagementSystem.Controllers.response.APIResponse;
import com.raySpot.ProductManagementSystem.dtos.requestDTO.CreateUserRequest;
import com.raySpot.ProductManagementSystem.dtos.requestDTO.DeleteUserRequest;
import com.raySpot.ProductManagementSystem.dtos.requestDTO.FindUserRequest;
import com.raySpot.ProductManagementSystem.dtos.requestDTO.UpdateUserDTO;
import com.raySpot.ProductManagementSystem.dtos.responseDTO.UserDTO;
import com.raySpot.ProductManagementSystem.exceptions.ProductManagementSystemException;
import com.raySpot.ProductManagementSystem.exceptions.UserNotFoundException;
import com.raySpot.ProductManagementSystem.models.User;
import com.raySpot.ProductManagementSystem.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //    handler method to handle homepage request
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        //create model object to store form data
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "register";
    }
    @PostMapping("/create")
    public ResponseEntity<?> createNewUser(@RequestBody CreateUserRequest createUserRequest) {
        try {
            APIResponse response = APIResponse.builder()
                    .payLoad(userService.createUser(createUserRequest))
                    .message("User Created Successfully")
                    .isSuccessful(true)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (ProductManagementSystemException exception) {
            APIResponse response = APIResponse.builder()
                    .message(exception.getMessage())
                    .isSuccessful(false)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserDTO updateUserDTO) {
        try {
            APIResponse response = APIResponse.builder()
                    .payLoad(userService.updateUser(updateUserDTO))
                    .message("User updated Successfully")
                    .isSuccessful(true)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (ProductManagementSystemException exception) {
            APIResponse response = APIResponse.builder()
                    .message(exception.getMessage())
                    .isSuccessful(false)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/allUser")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok().body(userService.getAllUser());
    }

    @GetMapping("/findByUserName")
    public ResponseEntity<?> findUserByUserName(@RequestBody FindUserRequest findUserRequest) {
        try {
            APIResponse response = APIResponse.builder()
                    .payLoad(userService.findUserByUserName(findUserRequest.getUserName()))
//                    .message("User updated Successfully")
                    .isSuccessful(true)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (UserNotFoundException exception) {
            APIResponse response = APIResponse.builder()
                    .message(exception.getMessage())
                    .isSuccessful(false)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByFirstName")
    public ResponseEntity<User> findUserByFirstName(@RequestBody FindUserRequest findUserRequest) {
        return ResponseEntity.ok().body(userService.findUserByFirstName(findUserRequest.getFirstName()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestBody DeleteUserRequest deleteUserRequest){
        try {
            APIResponse response = APIResponse.builder()
                    .payLoad(userService.deleteUser(deleteUserRequest.getUserName()))
                    .message("User deleted Successfully")
                    .isSuccessful(true)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (UserNotFoundException exception) {
            APIResponse response = APIResponse.builder()
                    .message(exception.getMessage())
                    .isSuccessful(false)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
//    public String deleteUser(@RequestBody String userName){
//        try{
//            userService.deleteUser(userName);
//            return "User deleted successfully";
//        } catch (Exception exception){
//            return "User does not exist!";
//        }
//    }
}
