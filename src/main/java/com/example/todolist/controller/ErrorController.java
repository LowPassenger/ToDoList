package com.example.todolist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/error/access-denied")
    public ResponseEntity<String> accessDenied() {
        return new ResponseEntity<>("Access denied!", HttpStatus.UNAUTHORIZED);
    }
}
