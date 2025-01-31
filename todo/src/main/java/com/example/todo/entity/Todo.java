package com.example.todo.entity;


import java.util.UUID;

public class Todo {

    private final UUID id;
    private String title;
    private String description;
    private Long createdAt;
    private Boolean isDone;
    private String tag;

    public Todo(String title, String description,String tag){
        this.id= UUID.randomUUID();
        this.title=title;
        this.description=description;
        this.createdAt=System.currentTimeMillis();
        this.isDone=false;
        this.tag=tag;
    }


    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getId() {
        return id;
    }
}
