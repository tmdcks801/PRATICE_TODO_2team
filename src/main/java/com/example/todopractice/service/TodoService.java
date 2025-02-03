package com.example.todopractice.service;

import com.example.todopractice.Entity.Todo;
import com.example.todopractice.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public List<Todo> getAllTodos(){
        List<Todo> todos = new ArrayList<>();

        return todos;
    }

    public Todo getTodo(UUID id) {
        Todo getTodo = todoRepository.getTodoById(id);
        return getTodo;
    }

    public Todo updateTodo(UUID id, Todo todo) {
        Todo getTodo = todoRepository.getTodoById(id);
        getTodo.setTitle(todo.getTitle());
        getTodo.setDescription(todo.getDescription());
        getTodo.setTag(todo.getTag());
        // isDone은?
        return getTodo;
    }
}
