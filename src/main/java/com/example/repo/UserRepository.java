package com.example.repo;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Bany on 2016-01-12.
 */
public interface UserRepository extends JpaRepository<User, String> {
}
