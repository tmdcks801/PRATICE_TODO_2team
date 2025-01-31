package com.example.todo.Service;

import com.example.todo.entity.Todo;

import java.util.UUID;

public interface Servicea {

    void createTodo(String title, String description,String tag);
    Todo[] readAll();
    Todo readTodo(UUID id);
    boolean update(UUID id,String title, String description, String tag);
    boolean delete(UUID id);
    Todo searchTag(String tag);
    Todo searchTitle(String title);
    void changeIsDone(UUID id ,Boolean done);

}
