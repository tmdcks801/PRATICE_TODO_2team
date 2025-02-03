package com.example.todopractice.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Todo {

    private UUID id;
    private String title;
    private String description;
    private LocalDateTime createAt;
    private boolean isDone;
    private String tag;

    public Todo(String title, String description, String tag){
        this.title = title;
        this.description = description;
        this.createAt = LocalDateTime.now();
        this.isDone = Boolean.FALSE;
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTag() {
        return tag;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsDone(boolean isDone){
        this.isDone = isDone;
    }
}
