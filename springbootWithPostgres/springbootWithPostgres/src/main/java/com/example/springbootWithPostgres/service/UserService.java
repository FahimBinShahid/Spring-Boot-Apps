package com.example.springbootWithPostgres.service;

import com.example.springbootWithPostgres.model.UserEntity;
import java.util.List;

public interface UserService {

    void saveUser(UserEntity user);

    void updateUser(UserEntity user, Integer userId);

    UserEntity getUserById(Integer userId);

    List<UserEntity> getAllUser();

    void deleteUserbyId(Integer userId);

}
