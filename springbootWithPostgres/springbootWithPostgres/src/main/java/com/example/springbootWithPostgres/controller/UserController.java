package com.example.springbootWithPostgres.controller;

import com.example.springbootWithPostgres.model.UserEntity;
import com.example.springbootWithPostgres.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUser() {
        List<UserEntity> users = userService.getAllUser();
        logger.info("Fetched users: {}", users);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Integer userId) {
        try {
            UserEntity user = userService.getUserById(userId);
            logger.info("Fetched user with id {}: {}", userId, user);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            logger.error("User not found with id {}", userId, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody UserEntity user) {
        userService.saveUser(user);
        logger.info("User saved: {}", user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User saved successfully.");
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUser(@RequestBody UserEntity user, @PathVariable Integer userId) {
        try {
            userService.updateUser(user, userId);
            logger.info("User updated with id {}: {}", userId, user);
            return ResponseEntity.ok("User updated successfully.");
        } catch (RuntimeException e) {
            logger.error("User not found with id {}", userId, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable Integer userId) {
        try {
            userService.deleteUserbyId(userId);
            logger.info("User deleted with id {}", userId);
            return ResponseEntity.ok("User deleted successfully.");
        } catch (RuntimeException e) {
            logger.error("User not found with id {}", userId, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }
}
