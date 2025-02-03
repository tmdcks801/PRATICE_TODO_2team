package com.example.todopractice.controller;


import com.example.todopractice.Entity.Todo;
import com.example.todopractice.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("/todos")
public class TodoController {

    private TodoService todoService;

    @GetMapping
    public ResponseEntity readAllTodos(){
        List<Todo> todos = todoService.getAllTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createTodo(@RequestBody Todo todo){
        Todo createTodo = new Todo(todo.getTitle(), todo.getDescription(), todo.getTag());
        return new ResponseEntity<>(createTodo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity readTodo(@PathVariable("id") UUID id){
        Todo readTodo = todoService.getTodo(id);
        return new ResponseEntity<>(readTodo, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTodo(@PathVariable("id") UUID id,
                                     @RequestBody Todo todo){
        Todo updatedTodo = todoService.updateTodo(id, todo);
        return new ResponseEntity(updatedTodo, HttpStatus.OK);
    }
}
