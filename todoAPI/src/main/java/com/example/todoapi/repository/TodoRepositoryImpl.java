package com.example.todoapi.repository;

import com.example.todoapi.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class TodoRepositoryImpl implements TodoRepository {
    private final List<Todo> todos = new ArrayList<>();

    @Override
    public Todo save(Todo todo) {
        todos.add(todo);
        return todo;
    }

    @Override
    public List<Todo> getAll() {
        return todos;
    }

    @Override
    public Optional<Todo> findById(UUID id) {
        return todos.stream().filter(todo -> todo.getId().equals(id)).findFirst();
    }

    @Override
    public void deleteById(UUID id) {
        todos.removeIf(todo -> todo.getId().equals(id));
    }

    @Override
    public List<Todo> findByTag(String tag) {
        return todos.stream().filter(todo -> todo.getTag().equalsIgnoreCase(tag)).collect(Collectors.toList());
    }

    @Override
    public List<Todo> findByTitle(String title) {
        return todos.stream().filter(todo -> todo.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
    }
}
