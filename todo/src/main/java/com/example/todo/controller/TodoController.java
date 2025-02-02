package com.example.todo.controller;

import com.example.todo.dto.TodoBodyDto;
import com.example.todo.dto.TodoListDto;
import com.example.todo.entity.Todo;
import com.example.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/todos")
public class TodoController {
  private final TodoService todoService;
  
  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }
  
  @PostMapping
  public void createTodo(TodoBodyDto todoBodyDto) {
    todoService.createTodo(todoBodyDto.getTitle(), todoBodyDto.getDescription(), todoBodyDto.getTag());
  }
  
  @GetMapping
  public void getAllTodos() {
    List<TodoListDto> todoListDtos = todoService.findAll();
  }
  
  @GetMapping("/{id}")
  public void getTodoById(@PathVariable UUID id) {
    Todo todo = todoService.findById(id);
  }
  
  @PutMapping("/{id}")
  public void updateTitle(@PathVariable UUID id, TodoBodyDto todoBodyDto) {
    todoService.updateTodo(id, todoBodyDto.getTitle(), todoBodyDto.getDescription(), todoBodyDto.getTag());
  }
  
  @GetMapping("?tag={tag}")
  public void getTodoByTag(@PathVariable String tag) {
    List<Todo> todos = todoService.findByTag(tag);
  }
  
  @GetMapping("?title={title}")
  public void getTodoByTitle(@PathVariable String title) {
    List<Todo> todos = todoService.findByTitle(title);
  }
  
  @DeleteMapping("/{id}")
  public void deleteTodoById(@PathVariable UUID id) {
    todoService.deleteTodo(id);
  }
}
