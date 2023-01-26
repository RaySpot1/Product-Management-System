package com.raySpot.ProductManagementSystem.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "ProductDB")
public class Product {
    @Id
    private long id;
    
    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)
    private String name;
    private String description;
    private LocalDateTime dateCreated = LocalDateTime.now();

    public Product(String name, String description){
        this.name = name;
        this.description = description;
    }

}
