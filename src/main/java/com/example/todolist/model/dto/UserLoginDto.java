package com.example.todolist.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserLoginDto {
    @NotBlank(message = "Login is mandatory")
    @Size(min = 4, message = "Login should have at least 4 characters")
    private String login;
    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password should have at least 8 characters")
    @Size(max = 30, message = "The password must contain no more than 30 characters")
    private String password;

    @Override
    public String toString() {
        return "User{"
                + ", login ='" + login + '\''
                + ", password='" + " OK!" + '\''
                + '}';
    }
}
