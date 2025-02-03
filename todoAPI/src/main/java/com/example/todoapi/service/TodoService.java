package com.example.todoapi.service;

import com.example.todoapi.Todo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoService {
    Todo createTodo(String title, String description, String tag);
    List<Todo> getAllTodos();
    Optional<Todo> getTodoById(UUID id);
    Todo updateTodo(UUID id, String title, String description, String tag);
    void deleteTodo(UUID id);
    List<Todo> searchByTag(String tag);
    List<Todo> searchByTitle(String title);
}
