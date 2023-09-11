package com.example.todolist.controller;

import com.example.todolist.model.ToDoTask;
import com.example.todolist.model.dto.ToDoTaskRequestDto;
import com.example.todolist.model.dto.ToDoTaskResponseDto;
import com.example.todolist.model.mapper.impl.ToDoTaskMapper;
import com.example.todolist.service.ToDoTaskService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/tasks")
public class ToDoTaskController {
    private final ToDoTaskService taskService;
    private final ToDoTaskMapper mapper;

    @Autowired
    public ToDoTaskController(ToDoTaskService taskService, ToDoTaskMapper mapper) {
        this.taskService = taskService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ToDoTaskRequestDto requestDto) {
        if (!taskService.dateTimeValidation(requestDto)) {
            log.warn("Task with description {} has invalid date parameter!",
                    requestDto.getDescription());
            return new ResponseEntity<>("Date of task is invalid!", HttpStatus.BAD_REQUEST);
        }
        ToDoTaskResponseDto responseDto = mapper.toDto(taskService
                .create(mapper.toModel(requestDto)));
        log.info("Task with id {} was successfully created!",
                responseDto.getId());
        return new ResponseEntity<>(mapper.toDto(taskService.create(mapper.toModel(requestDto))),
            HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ToDoTaskResponseDto>> getAll() {
        return ResponseEntity.ok(taskService.getAll()
                .stream()
                .map(mapper::toDto)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoTaskResponseDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(mapper.toDto(taskService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable("id") Long id,
            @RequestBody ToDoTaskRequestDto requestDto) {
        if (!taskService.dateTimeValidation(requestDto)) {
            log.warn("Task with id {} has invalid date parameter!",
                    id);
            return new ResponseEntity<>("Date of task is invalid!", HttpStatus.BAD_REQUEST);
        }
        log.info("Task with id {} was successfully updated!", id);
        return ResponseEntity.ok(mapper.toDto(taskService.update(id, mapper.toModel(requestDto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        taskService.deleteById(id);
        log.info("Task with id {} was successfully deleted!", id);
        return ResponseEntity.ok("Success, delete ToDoTask by id" + id);
    }

    @PostMapping("/all-by-status")
    public ResponseEntity<?> getAllByStatus(@RequestBody String status) {
        List<ToDoTask> list = taskService.getAllByStatus(status);
        if (list == null || list.isEmpty()) {
            return new ResponseEntity<>("Any information about tasks with status "
                    + status + " or bad request", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(list
                .stream()
                .map(mapper::toDto)
                .toList());
    }
}
