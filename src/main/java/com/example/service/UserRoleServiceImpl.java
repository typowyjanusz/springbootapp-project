package com.example.service;

import com.example.model.UserRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import com.example.repo.UserRoleRepository;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Bany on 2016-01-13.
 */
@Service
@Validated
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository repositoryRole;

    @Inject
    public UserRoleServiceImpl(final UserRoleRepository repositoryRole) {
        this.repositoryRole = repositoryRole;
    }

    @Override
    @Transactional
    public UserRole save(@NotNull @Valid final UserRole userRole) {
        return repositoryRole.save(userRole);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserRole> getList() {
        return repositoryRole.findAll();
    }

}
