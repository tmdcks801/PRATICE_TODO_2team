package com.codeit.todoapidesign.repository;

import com.codeit.todoapidesign.Todo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;


@Repository
public class TodoRepositoryImpl implements TodoRepository {
    // 자료구조 : HashMap
    // HashMap<String, Object> / HashMap<String, TODO >
    // 후자 선택, TO_DO의 속성이 총 6개로 validation 체크하기도 힘들 것 같아서.
    Map<UUID, Todo> todos = new HashMap<>();


    @Override
    public Todo save(Todo todo) {
        todos.put(todo.getId(), todo);
        return todos.get(todo.getId());
    }

    @Override
    public Todo update(Todo todo){
        return todos.put(todo.getId(), todo);
    }

    @Override
    public List<Todo> getAll() {
        // stream을 통한 불변 List 반환
        // getAll은 읽기 용이고, 코드가 간결하다.
        return todos.values().stream().toList();
    }

    @Override
    public Todo getById(UUID id) {
        return todos.get(id);
    }

    @Override
    public boolean deleteById(UUID id) {
        return todos.remove(id) == null;
    }
}
