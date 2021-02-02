package com.training.courier.exception;

public class CourierNotFoundException extends RuntimeException{
    public CourierNotFoundException(Long id) {
        super("Courier with " + id + " not found");
    }
}
