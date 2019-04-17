package com.rentcar.app.exception;

public class UserNotFoundException extends RuntimeException {

    private static final String USER_NOT_FOUND_EXCEPTION = "User with id doesnt exist! ";

    public UserNotFoundException(String message) {
        super(USER_NOT_FOUND_EXCEPTION + message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
