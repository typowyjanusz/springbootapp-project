package com.example.service;

import com.example.model.UserRole;

import java.util.List;

/**
 * Created by Bany on 2016-01-13.
 */
public interface UserRoleService {

    UserRole save(UserRole userRole);

    List<UserRole> getList();

}
