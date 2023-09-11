package com.example.todolist.exception;

import org.springframework.http.HttpStatus;

public class ToDoTaskApiException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public ToDoTaskApiException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public ToDoTaskApiException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }
}
