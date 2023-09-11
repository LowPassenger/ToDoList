package com.example.todolist.service;

import com.example.todolist.exception.ResourceNotFoundException;
import com.example.todolist.model.ToDoTask;
import com.example.todolist.model.dto.ToDoTaskRequestDto;
import com.example.todolist.model.enums.Status;
import com.example.todolist.repository.ToDoTaskRepository;
import com.example.todolist.utils.DateTimeFormatValidator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoTaskService {
    private final ToDoTaskRepository taskRepository;
    private final DateTimeFormatValidator validator;

    @Autowired
    public ToDoTaskService(ToDoTaskRepository taskRepository, DateTimeFormatValidator validator) {
        this.taskRepository = taskRepository;
        this.validator = validator;
    }

    public ToDoTask create(ToDoTask task) {
        return taskRepository.save(task);
    }

    public List<ToDoTask> getAll() {
        return taskRepository.findAll();
    }

    public ToDoTask getById(Long id) {
        return taskRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("ToDoTask", "id", String.valueOf(id))
        );
    }

    public ToDoTask update(Long id, ToDoTask task) {
        task.setId(id);
        return taskRepository.save(task);
    }

    public boolean deleteById(Long id) {
        ToDoTask task = taskRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("ToDoTask", "id", String.valueOf(id)));
        taskRepository.delete(task);
        return taskRepository.existsById(id);
    }

    public List<ToDoTask> getAllByStatus(String statusName) {
        return taskRepository.findAllByStatus(Status.valueOf(statusName));
    }

    public boolean dateTimeValidation(ToDoTaskRequestDto requestDto) {
        return (validator.isValid(requestDto.getCreationTime())
                & validator.isValid(requestDto.getExpirationTime()));
    }
}
