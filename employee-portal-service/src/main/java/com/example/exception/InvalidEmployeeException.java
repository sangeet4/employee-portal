package com.example.exception;

public class InvalidEmployeeException extends Exception{
    public InvalidEmployeeException() {
    }

    public InvalidEmployeeException(String message) {
        super(message);
    }
}
