package com.example.todo.repository;

import com.example.todo.entity.Todo;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class TodoRepositoryAdaptor implements TodoRepository {
  private final List<Todo> todos = new ArrayList<>();
  
  @Override
  public void save(Todo todo) {
    todos.add(todo);
  }
  
  @Override
  public Optional<Todo> findById(UUID id) {
    return todos.stream().filter(t -> t.getId().equals(id)).findFirst();
  }
  
  @Override
  public List<Todo> findByTitle(String title) {
    return todos.stream().filter(t->t.getTitle().equals(title)).toList();
  }
  
  @Override
  public List<Todo> findByTag(String tag) {
    return todos.stream().filter(t->t.getTag().equals(tag)).toList();
  }
  
  @Override
  public List<Todo> findAll() {
    return todos;
  }
  
  @Override
  public void deleteTodo(UUID id) {
    Optional<Todo> todo = findById(id);
    todo.ifPresent(todos::remove);
  }
  
  @Override
  public void updateTodo(UUID id, String title, String description, String tag) {
    Optional<Todo> todo = findById(id);
    todo.ifPresent(t -> t.updateTodo(title, description, tag));
  }
  
  
}
