package com.example.todo.service;

import com.example.todo.dto.TodoListDto;
import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class TodoService {
  private final TodoRepository todoRepository;
  
  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }
  
  public void createTodo(String title, String description, String tag) {
    Todo todo = new Todo(title, description, tag);
    todoRepository.save(todo);
  }
  
  public Todo findById(UUID id) {
    return todoRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("todo not found ( id: " + id + " )"));
  }
  
  public List<Todo> findByTitle(String title) {
    List<Todo> todos = todoRepository.findByTitle(title);
    if (todos.isEmpty()) {
      throw new IllegalArgumentException("no such title : " + title);
    }
    return todos;
  }
  
  public List<Todo> findByTag(String tag) {
    List<Todo> todos = todoRepository.findByTag(tag);
    if (todos.isEmpty()) {
      throw new IllegalArgumentException("no such tag : " + tag);
    }
    return todos;
  }
  
  public List<TodoListDto> findAll() {
    List<TodoListDto> todos = todoRepository.findAll().stream()
        .map(t -> new TodoListDto(t.getTitle(), t.getTag()))
        .toList();
    return todos;
  }
  
  public void updateTodo(UUID id, String title, String description, String tag) {
    todoRepository.updateTodo(id, title, description, tag);
  }
  
  public void deleteTodo(UUID id){
    todoRepository.deleteTodo(id);
  }
}
