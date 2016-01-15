package com.example.service;

import com.example.model.User;

import java.util.List;

/**
 * Created by Bany on 2016-01-12.
 */
public interface UserService {

    User save(User user);

    List<User> getList();

}
