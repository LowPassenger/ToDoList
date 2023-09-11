package com.example.todolist.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    NEW("New"),
    CURRENT("Current"),
    URGENT("Urgent"),
    DONE("Done"),
    ARCHIVE("Archive");

    private final String value;
}
