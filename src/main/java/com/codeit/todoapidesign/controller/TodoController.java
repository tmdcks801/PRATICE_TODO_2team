package com.codeit.todoapidesign.controller;

import com.codeit.todoapidesign.ErrorResponse;
import com.codeit.todoapidesign.Todo;
import com.codeit.todoapidesign.service.TodoService;
import com.codeit.todoapidesign.service.TodoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

// TodoController 클래스를 웹 서비스의 컨트롤러로 지정한다.
@RestController

// TodoController 클래스의 기본 URL 경로를 /todos 로 지정한다.
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService){this.todoService = todoService;}


    // HTTP MEHTOD POST 요청
    @PostMapping
    public Todo postTodo(@RequestBody Todo todo){
        return todoService.saveTodo(todo);
    }

    // HTTP METHOD PUT 요청
    // RESTful 하다
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable UUID id, @RequestBody Todo todo){
        return todoService.updateTodo(todo);
    }


    // HTTP METHOD GET 요청
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable UUID id){
        return todoService.getTodoById(id);
    }
    @GetMapping("/tag")
    public List<Todo> getTodoByTag(@RequestParam String tag){
        return todoService.getTodoByTag(tag);
    }
    @GetMapping("/title")
    public List<Todo> getTodoByTitle(@RequestParam String title){
        return todoService.getTodoByTitle(title);
    }

    // HTTP METHOD DELETE 요청
    @DeleteMapping("/{id}")
    public boolean deleteTodoByid(@PathVariable UUID id){
        return todoService.deleteTodoById(id);
    }
}
