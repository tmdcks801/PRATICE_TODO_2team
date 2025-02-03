package com.example.todoapi.controller;

import com.example.todoapi.Todo;
import com.example.todoapi.service.TodoService;
import com.example.todoapi.service.TodoServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public Todo postTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo.getTitle(), todo.getDescription(), todo.getTag());
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable UUID id, @RequestBody Todo todo) {
        return todoService.updateTodo(id, todo.getTitle(), todo.getDescription(), todo.getTag());
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable UUID id) {
        return todoService.getTodoById(id).orElse(null);
    }

    @GetMapping("/tag")
    public List<Todo> getTodoByTag(@RequestParam String tag) {
        return todoService.searchByTag(tag);
    }

    @GetMapping("/title")
    public List<Todo> getTodoByTitle(@RequestParam String title) {
        return todoService.searchByTitle(title);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable UUID id) {
        todoService.deleteTodo(id);
    }
}
