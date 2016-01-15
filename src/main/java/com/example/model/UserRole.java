package com.example.model;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Bany on 2016-01-13.
 */
@Entity(name = "user_roles")
public class UserRole {

    @Id
    @NotNull
    @Size(max = 20)
    @Column(name = "username")
    private String username;


    @Column(name = "role")
    private String role = "USER";

    private UserRole() {
    }

    public UserRole(final String username, final String role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("username", username)
                .add("role", role)
                .toString();
    }
}
