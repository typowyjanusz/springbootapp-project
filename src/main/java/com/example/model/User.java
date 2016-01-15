package com.example.model;

import com.google.common.base.Objects;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * Created by Bany on 2016-01-12.
 */
@Entity(name = "users")
public class User {

    @Id
    @NotNull
    @Size(max = 20)
    @Column(name = "username")
    private String username;

    @NotNull
    @Size(max = 20)
    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Integer enabled = 1;

    private String errorName = null;

    private User() {
    }

    public User(final String username, final String password, final Integer enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setError(String errorName) {
        this.errorName = errorName;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("username", username)
                .add("password", password)
                .add("enabled", enabled)
                .toString();
    }
}
