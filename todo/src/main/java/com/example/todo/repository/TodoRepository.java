package com.example.todo.repository;

import com.example.todo.entity.Todo;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoRepository {
  void save(Todo todo);
  Optional<Todo> findById(UUID id);
  List<Todo> findByTitle(String title);
  List<Todo> findByTag(String tag);
  List<Todo> findAll();
  void deleteTodo(UUID id);
  void updateTodo(UUID id, String title, String description, String tag);
}
