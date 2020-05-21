package com.example.main.exception;

public class WorksNotFoundExeption extends RuntimeException{
    public WorksNotFoundExeption(String message) {
        super(message);
    }
}
