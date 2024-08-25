package com.todo.todoapp.Controller;

import com.todo.todoapp.Model.User;
import com.todo.todoapp.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(@PathVariable Long taskId) {
        List<User> users = userService.getUsersByTaskId(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long taskId, @PathVariable Long userId) {
        User user = userService.getUserById(taskId, userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@PathVariable Long taskId, @RequestBody User user) {
        User createdUser = userService.addUser(taskId, user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long taskId, @PathVariable Long userId, @RequestBody User user) {
        User updatedUser = userService.updateUser(taskId, userId, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long taskId, @PathVariable Long userId) {
        userService.deleteUser(taskId, userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
