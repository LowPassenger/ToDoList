package com.example.todolist.model.dto;

import com.example.todolist.model.Role;
import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserRequestDto {
    private String login;
    private String password;
    private Set<Role> roles;

    @Override
    public String toString() {
        return "User{"
                + ", login ='" + login + '\''
                + ", password='" + " OK!" + '\''
                + '}';
    }
}
