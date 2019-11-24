package com.example.exception;

public class NoEmployeeExistsException extends Exception{
    public NoEmployeeExistsException() {
    }

    public NoEmployeeExistsException(String message) {
        super(message);
    }
}
