package com.example.todo.Service;

import com.example.todo.Repository.TODOREPO;
import com.example.todo.entity.Todo;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class TodoService implements Servicea{

    TODOREPO repo=new TODOREPO();


    @Override
    public void createTodo(String title, String description, String tag) {
        repo.createTodo(title,description,tag);
    }

    @Override
    public Todo[] readAll() {
        return repo.readAll();
    }

    @Override
    public Todo readTodo(UUID id) {
        return repo.readTodo(id);

    }

    @Override
    public boolean update(UUID id, String title, String description, String tag) {
        return repo.update(id,title,description,tag);
    }

    @Override
    public boolean delete(UUID id) {
        return repo.delete(id);
    }

    @Override
    public Todo searchTag(String tag) {
        return repo.searchTag(tag);
    }

    @Override
    public Todo searchTitle(String title) {
        return repo.searchTitle(title);
    }

    @Override
    public void changeIsDone(UUID id, Boolean done) {
        repo.changeIsDone(id,done);
    }
}
