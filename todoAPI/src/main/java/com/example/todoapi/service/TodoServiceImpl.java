package com.example.todoapi.service;

import com.example.todoapi.Todo;
import com.example.todoapi.repository.TodoRepository;
import com.example.todoapi.repository.TodoRepositoryImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public class TodoServiceImpl implements TodoService {
    private final TodoRepository repository = new TodoRepositoryImpl();

    @Override
    public Todo createTodo(String title, String description, String tag) {
        Todo todo = new Todo(title, description, tag);
        return repository.save(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
        return repository.getAll();
    }

    @Override
    public Optional<Todo> getTodoById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Todo updateTodo(UUID id, String title, String description, String tag) {
        Optional<Todo> optionalTodo = repository.findById(id);
        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todo.setTitle(title);
            todo.setDescription(description);
            todo.setTag(tag);
            return todo;
        } else {
            throw new NoSuchElementException("Todo not found");
        }
    }

    @Override
    public void deleteTodo(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<Todo> searchByTag(String tag) {
        return repository.findByTag(tag);
    }

    @Override
    public List<Todo> searchByTitle(String title) {
        return repository.findByTitle(title);
    }
}
