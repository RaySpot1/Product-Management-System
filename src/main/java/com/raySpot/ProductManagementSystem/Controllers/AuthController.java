package com.raySpot.ProductManagementSystem.Controllers;

import com.raySpot.ProductManagementSystem.dtos.requestDTO.CreateUserRequest;
import com.raySpot.ProductManagementSystem.models.User;
import com.raySpot.ProductManagementSystem.services.UserService;
import jakarta.validation.Valid;
import com.raySpot.ProductManagementSystem.dtos.responseDTO.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }

//    handler method to handle homepage request
    @GetMapping("/index")
    public String home(){
        return "index";
    }

//    handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationPage(Model model){
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "register";
    }

//    handler method to handle user registration form request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDTO userDTO,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByUserName(userDTO.getUserName());

        if(existingUser != null && existingUser.getUserName() != null && !existingUser.getUserName().isEmpty()){
            result.rejectValue("userName", null, "Username already exist!");
        }
        if(result.hasErrors()){
            model.addAttribute("user", userDTO);
            return "/register";
        }

        userService.createUser(CreateUserRequest.builder().build());
        return "redirect:/register?success";

    }
}
