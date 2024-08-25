package com.todo.todoapp.Service;

import com.todo.todoapp.Model.User;
import com.todo.todoapp.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsersByTaskId(Long taskId) {
        return userRepository.findByTasksId(taskId);
    }

    public User getUserById(Long id, Long userId) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User with id " + id + " not found"));
    }

    public User addUser(Long taskId, User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, Long userId, User user) {
        User existingUser = getUserById(id, userId);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setGender(user.getGender());
        existingUser.setJobTitle(user.getJobTitle());
        existingUser.setPhone(user.getPhone());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id, Long userId) {
        User user = getUserById(id, userId);
        userRepository.delete(user);
    }
}
