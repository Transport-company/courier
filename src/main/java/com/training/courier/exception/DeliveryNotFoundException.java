package com.training.courier.exception;

public class DeliveryNotFoundException extends RuntimeException{
    public DeliveryNotFoundException(Long id) {
        super("Delivery with id: " + id + " not found");
    }
}
