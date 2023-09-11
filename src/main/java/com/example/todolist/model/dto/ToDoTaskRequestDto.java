package com.example.todolist.model.dto;

import com.example.todolist.model.User;
import com.example.todolist.model.enums.Status;
import lombok.Data;

@Data
public class ToDoTaskRequestDto {
    private User user;
    private String creationTime;
    private String expirationTime;
    private Status status;
    private String description;
    private String body;
}
