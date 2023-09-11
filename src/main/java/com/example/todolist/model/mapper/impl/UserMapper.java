package com.example.todolist.model.mapper.impl;

import com.example.todolist.model.User;
import com.example.todolist.model.dto.UserRequestDto;
import com.example.todolist.model.dto.UserResponseDto;
import com.example.todolist.model.mapper.MapperToDto;
import com.example.todolist.model.mapper.MapperToModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements MapperToModel<User, UserRequestDto>,
        MapperToDto<UserResponseDto, User> {
    @Override
    public UserResponseDto toDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setLogin(user.getLogin());
        responseDto.setPassword(user.getPassword());
        return responseDto;
    }

    @Override
    public User toModel(UserRequestDto requestDto) {
        User user = new User();
        user.setLogin(requestDto.getLogin());
        user.setPassword(requestDto.getPassword());
        return user;
    }
}
