package com.training.courier.exception;

public class CourierNotFoundException extends RuntimeException{
    public CourierNotFoundException(Long id) {
        super("Courier with id: " + id + " not found");
    }

    public CourierNotFoundException(String city) {
        super("Courier for the city: \"" + city +"\" not found");
    }
}
