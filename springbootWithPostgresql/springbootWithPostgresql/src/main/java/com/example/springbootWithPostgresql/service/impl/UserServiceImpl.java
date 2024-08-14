package com.example.springbootWithPostgresql.service.impl;

import com.example.springbootWithPostgresql.entity.UserEntity;
import com.example.springbootWithPostgresql.repository.UserRepository;
import com.example.springbootWithPostgresql.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(Integer userId) {
        return null;
    }

    @Override
    public void saveUser(UserEntity user) {
        Optional<UserEntity> existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser.isPresent()) {
            userRepository.delete(user);
        }
        UserEntity userDetail = userRepository.save(user);
        System.out.println("user saved to db with userId : " + userDetail.getId());
    }

    @Override
    public void updateUser(UserEntity user, Integer userid) {
        UserEntity userDetail = userRepository.findById(userid).get();
        userDetail.setName(user.getName());
        userDetail.setEmail(user.getEmail());
        userRepository.save(userDetail);
    }
    @Override
    public void deleteUseryId(Integer userId) {
        Optional<UserEntity> userOpt = userRepository.findById(userId);
        if(userOpt.isPresent())
            userRepository.deleteById(userId);
        else
            throw new RuntimeException("user not found.");
    }
}
