package com.example.todolist.controller;

import com.example.todolist.config.SecurityConfig;
import com.example.todolist.model.dto.UserLoginDto;
import com.example.todolist.security.jwt.JwtAuthResponse;
import com.example.todolist.service.AuthenticationService;
import com.example.todolist.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Import(SecurityConfig.class)
@RestController
@RequestMapping("api/v1/login")
public class LoginController {
    private final AuthenticationService authenticationService;
    private final UserService userService;

    @Autowired
    public LoginController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("sign-in")
    public ResponseEntity<JwtAuthResponse> authentication(
            @Valid @RequestBody UserLoginDto loginDto) {
        String token = authenticationService.authentication(loginDto);
        return ResponseEntity.ok(new JwtAuthResponse(token));
    }

    @PostMapping("sign-up")
    public ResponseEntity<String> registration(@Valid @RequestBody UserLoginDto loginDto) {
        String login = loginDto.getLogin();
        if (userService.existByLogin(login)) {
            log.info("User registration with login " + login + " failed. Login already exist!");
            return new ResponseEntity<>("Login is already taken!", HttpStatus.BAD_REQUEST);
        }
        authenticationService.registerUser(loginDto);
        log.info("User with login {} was successfully created.", loginDto.getLogin());
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }
}
