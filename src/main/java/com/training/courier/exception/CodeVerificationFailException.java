package com.training.courier.exception;

public class CodeVerificationFailException extends RuntimeException{

    public CodeVerificationFailException(String message) {
        super(message);
    }
}
