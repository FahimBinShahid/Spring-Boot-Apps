package com.example.springbootWithPostgres.impl;

import com.example.springbootWithPostgres.model.UserEntity;
import com.example.springbootWithPostgres.repository.UserRepository;
import com.example.springbootWithPostgres.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

    @Override
    public void saveUser(UserEntity user) {
        UserEntity userDetail = userRepository.save(user);
        System.out.println("User saved to db with userId: " + userDetail.getId());
    }

    @Override
    public void updateUser(UserEntity user, Integer userId) {
        UserEntity userDetail = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        // Update fields if they are not null or empty
        if (user.getName() != null && !user.getName().isEmpty()) {
            userDetail.setName(user.getName());
        }
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            userDetail.setPassword(user.getPassword());
        }
        if (user.getCity() != null && !user.getCity().isEmpty()) {
            userDetail.setCity(user.getCity());
        }
        userRepository.save(userDetail);
    }

    @Override
    public void deleteUserbyId(Integer userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }
}
