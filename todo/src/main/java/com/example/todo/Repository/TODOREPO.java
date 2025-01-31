package com.example.todo.Repository;

import com.example.todo.entity.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class TODOREPO implements REPO {

    Map <UUID, Todo> repositoryTodo;

    public TODOREPO(){
        repositoryTodo = new LinkedHashMap<>();
    }


    @Override
    public void createTodo(String title, String description, String tag) {
        Todo newTodo=new Todo(title,description,tag);
        repositoryTodo.put(newTodo.getId(),newTodo);
    }

    @Override
    public Todo[] readAll() {
        Todo[] array=new Todo[repositoryTodo.size()];
        int index = 0;
        for (Todo todo : repositoryTodo.values()) {
            array[index++] = todo;
        }
        return array;
    }

    @Override
    public Todo readTodo(UUID id) {
        return repositoryTodo.get(id);
    }

    @Override
    public boolean update(UUID id,String title, String description, String tag) {
        Todo thing=repositoryTodo.get(id);
        thing.setDescription(description);
        thing.setTitle(title);
        thing.setTag(tag);
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        if(!repositoryTodo.containsKey(id))
            return false;
        repositoryTodo.remove(id);
        return true;
    }

    @Override
    public Todo searchTag(String tag){
        for (Todo todo : repositoryTodo.values()) {
            if (todo.getTag().equals(tag)) {
                return todo;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found");
    }


    @Override
    public Todo searchTitle(String title) {
        for (Todo todo : repositoryTodo.values()) {
            if (todo.getTitle().equals(title)) {
                return todo;  // 정상적인 Todo 객체 반환
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found");
    }
    @Override
    public void changeIsDone(UUID id ,Boolean done){
        repositoryTodo.get(id).setDone(done);
    }
}
