package com.example.todoapi.repository;

import com.example.todoapi.Todo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoRepository {
    Todo save(Todo todo);
    List<Todo> getAll();
    Optional<Todo> findById(UUID id);
    void deleteById(UUID id);
    List<Todo> findByTag(String tag);
    List<Todo> findByTitle(String title);
}
