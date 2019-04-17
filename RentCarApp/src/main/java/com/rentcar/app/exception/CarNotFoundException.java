package com.rentcar.app.exception;

public class CarNotFoundException extends RuntimeException {

    private static final String CAR_NOT_FOUND_EXCEPTION = "Car with id doesnt exist! ";

    public CarNotFoundException(String message) {
        super(CAR_NOT_FOUND_EXCEPTION + message);
    }

    public CarNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
