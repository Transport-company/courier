package com.training.courier.exception;

public class CourierAlreadyExistsException extends RuntimeException {
    public CourierAlreadyExistsException(String phoneNumber) {
        super("Courier with phone number: " + phoneNumber + " already exists");
    }
}
