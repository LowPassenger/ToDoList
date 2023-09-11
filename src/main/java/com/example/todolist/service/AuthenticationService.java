package com.example.todolist.service;

import com.example.todolist.model.Role;
import com.example.todolist.model.User;
import com.example.todolist.model.dto.UserLoginDto;
import com.example.todolist.repository.UserRepository;
import com.example.todolist.security.jwt.JwtTokenProvider;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;

    @Autowired
    public AuthenticationService(AuthenticationManager authenticationManager,
                                 UserRepository userRepository,
                                 RoleService roleService,
                                 PasswordEncoder passwordEncoder,
                                 JwtTokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    public String authentication(UserLoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getLogin(), loginDto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return tokenProvider.generateToken(authentication);
    }

    public User registerUser(UserLoginDto requestDto) {
        User user = new User();
        user.setLogin(requestDto.getLogin());
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        Role roles = roleService.getByName("USER");
        user.setRoles(Collections.singleton(roles));
        userRepository.save(user);
        return user;
    }
}
