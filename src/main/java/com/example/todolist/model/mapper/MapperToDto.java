package com.example.todolist.model.mapper;

public interface MapperToDto<U, V> {
    U toDto(V v);
}
