package com.training.courier.exception;

public class SalaryNotFoundException extends RuntimeException{
    public SalaryNotFoundException(Long id) {
        super("Salary entry with " + id + " not found");
    }
}
