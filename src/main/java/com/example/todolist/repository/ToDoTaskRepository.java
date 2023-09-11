package com.example.todolist.repository;

import com.example.todolist.model.ToDoTask;
import com.example.todolist.model.enums.Status;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoTaskRepository extends JpaRepository<ToDoTask, Long> {
    List<ToDoTask> findAllByStatus(Status status);
}
