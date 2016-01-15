package com.example.model;

import com.google.common.base.Objects;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Bany on 2016-01-12.
 */
public class UserCreate {


    @Size(min=5, max = 20)
    private String username1;

    @Size(min=5,max = 20)
    private String password1;

    private String password2;

    public String getUsername1() {
        return username1;
    }

    public void setusername1(String username1) {
        this.username1 = username1;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }



    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("username1", username1)
                .add("password1", password1)
                .add("password2", password2)
                .toString();
    }
}
