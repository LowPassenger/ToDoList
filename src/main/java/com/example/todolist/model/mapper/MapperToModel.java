package com.example.todolist.model.mapper;

public interface MapperToModel<V, T> {
    V toModel(T t);
}
