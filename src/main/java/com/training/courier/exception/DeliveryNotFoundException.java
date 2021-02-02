package com.training.courier.exception;

public class CourierDeliveryNotFoundException extends RuntimeException{
    public CourierDeliveryNotFoundException(Long id) {
        super("Courier delivery with " + id + " not found");
    }
}
