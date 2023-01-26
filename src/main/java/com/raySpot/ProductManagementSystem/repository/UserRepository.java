package com.raySpot.ProductManagementSystem.repository;

import com.raySpot.ProductManagementSystem.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String>{
    Optional<User> findUserByUserName(String userName);

    Optional<User> findUserByFirstName(String firstName);
}
