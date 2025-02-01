package com.codeit.todoapidesign.service;

import com.codeit.todoapidesign.Todo;
import com.codeit.todoapidesign.repository.TodoRepository;
import com.codeit.todoapidesign.repository.TodoRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService{

    // 인터페이스에 의존하여 DIP 원칙 지키기
    // final + 생성자를 통한 불변성 유지
    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }


    @Override
    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Todo todo){
        return todoRepository.update(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.getAll();
    }

    @Override
    public Todo getTodoById(UUID id) {
        return todoRepository.getById(id);
    }

    @Override
    public boolean deleteTodoById(UUID id) {
        return todoRepository.deleteById(id);
    }

    @Override
    public List<Todo> getTodoByTag(String tag) {
        return todoRepository.getAll().stream()
                .filter( todo -> todo.getTag().equals(tag))
                // 변경될 일이 없기 때문에 toList() 메서드 사용
                //.collect(Collectors.toList());
                .toList();
    }

    @Override
    public List<Todo> getTodoByTitle(String title) {
        return todoRepository.getAll().stream()
                .filter( todo -> todo.getTitle().equals(title))
                .toList();
    }
}
