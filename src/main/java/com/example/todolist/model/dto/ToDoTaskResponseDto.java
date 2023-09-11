package com.example.todolist.model.dto;

import com.example.todolist.model.User;
import com.example.todolist.model.enums.Status;
import lombok.Data;

@Data
public class ToDoTaskResponseDto {
    private Long id;
    private User user;
    private String creationPoint;
    private String expirationPoint;
    private Status status;
    private String description;
    private String body;
}
