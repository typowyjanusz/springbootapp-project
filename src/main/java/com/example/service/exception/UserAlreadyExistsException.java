package com.example.service.exception;

/**
 * Created by Janusz on 2016-01-14.
 */
public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(final String message) {
        super(message);
    }

}