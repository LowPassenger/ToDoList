package com.example.todolist.model.mapper.impl;

import com.example.todolist.model.ToDoTask;
import com.example.todolist.model.dto.ToDoTaskRequestDto;
import com.example.todolist.model.dto.ToDoTaskResponseDto;
import com.example.todolist.model.mapper.MapperToDto;
import com.example.todolist.model.mapper.MapperToModel;
import org.springframework.stereotype.Component;

@Component
public class ToDoTaskMapper implements MapperToModel<ToDoTask, ToDoTaskRequestDto>,
        MapperToDto<ToDoTaskResponseDto, ToDoTask> {

    @Override
    public ToDoTaskResponseDto toDto(ToDoTask toDoTask) {
        ToDoTaskResponseDto responseDto = new ToDoTaskResponseDto();
        responseDto.setId(toDoTask.getId());
        responseDto.setCreationPoint(toDoTask.getCreationPoint());
        responseDto.setExpirationPoint(toDoTask.getExpirationPoint());
        responseDto.setStatus(toDoTask.getStatus());
        responseDto.setDescription(toDoTask.getDescription());
        responseDto.setBody(toDoTask.getBody());
        return responseDto;
    }

    @Override
    public ToDoTask toModel(ToDoTaskRequestDto toDoTaskRequestDto) {
        ToDoTask task = new ToDoTask();
        task.setCreationPoint(toDoTaskRequestDto.getCreationTime());
        task.setExpirationPoint(toDoTaskRequestDto.getExpirationTime());
        task.setStatus(toDoTaskRequestDto.getStatus());
        task.setDescription(toDoTaskRequestDto.getDescription());
        task.setBody(toDoTaskRequestDto.getBody());
        return task;
    }
}
