package com.example.todolist.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Roles {
    ROLE_USER("USER"),
    ROLE_ADMIN("ADMIN"),
    ROLE_MODERATOR("MODERATOR");

    private String roleName;
}
