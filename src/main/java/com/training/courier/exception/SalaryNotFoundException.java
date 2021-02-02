package com.training.courier.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(Long id) {
        super("Entity with " + id + " not found");
    }
}
