package com.example.todolist.service;

import com.example.todolist.exception.ResourceNotFoundException;
import com.example.todolist.model.User;
import com.example.todolist.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getByLogin(String login) {
        return userRepository.findByLogin(login).orElseThrow(
                () -> new ResourceNotFoundException("User", "login", login)
        );
    }

    public boolean existByLogin(String login) {
        return userRepository.existsByLogin(login);
    }

    public User create(User user) {
        return userRepository.save(user);
    }
}
