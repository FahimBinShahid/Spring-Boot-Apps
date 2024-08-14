package com.example.springbootWithPostgresql.service;

import com.example.springbootWithPostgresql.entity.UserEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface UserService {



    List<UserEntity> getAllUser();

    UserEntity getUserById(Integer userId);

    void saveUser(UserEntity user);

    void updateUser(UserEntity user, Integer userid);

    void deleteUseryId(Integer userId);

}
