package com.example.todolist.model;

import com.example.todolist.model.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "tasks")
public class ToDoTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    @Column(name = "creation_time")
    private String creationPoint;
    @Column(name = "expiration_time")
    private String expirationPoint;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar (20)")
    private Status status;
    @Column(columnDefinition = "TINYTEXT")
    private String description;
    @Lob
    private String body;
}
