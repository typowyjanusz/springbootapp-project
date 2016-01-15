package com.example.repo;

import com.example.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Bany on 2016-01-13.
 */
public interface UserRoleRepository extends JpaRepository<UserRole, String> {
}
