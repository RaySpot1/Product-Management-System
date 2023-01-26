package com.raySpot.ProductManagementSystem.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "UsersDB")
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @NotBlank(message = "Username should not be empty")
    @Size(max = 100)
    private String userName;

    private String firstName;

    private Product product;

    @NotBlank(message = "Password should not be empty")
    private String password;
    private LocalDateTime localDateTime;

    public User(String userName, String password, Product product){
        this.userName = userName;
        this.password = password;
        this.product = product;
    }
}
