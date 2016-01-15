package com.example.service;

import com.example.model.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import com.example.repo.UserRepository;
import com.example.service.exception.UserAlreadyExistsException;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Bany on 2016-01-12.
 */
@Service
@Validated
public class UserServiceImpl implements UserService {

    private final UserRepository repositoryUser;

    @Inject
    public UserServiceImpl(final UserRepository repositoryUser) {
        this.repositoryUser = repositoryUser;
    }

    @Override
    @Transactional
    public User save(@NotNull @Valid final User user) {
        User existing = repositoryUser.findOne(user.getUsername());
        if (existing != null) {
            user.setError("Username already exists");
            throw new UserAlreadyExistsException(String.format("There already exists a user with username = %s", user.getUsername()));
        }
        return repositoryUser.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getList() {
        return repositoryUser.findAll();
    }

}
