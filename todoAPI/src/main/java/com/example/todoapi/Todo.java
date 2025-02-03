package com.example.todoapi;

import java.time.LocalDateTime;
import java.util.UUID;

public class Todo {
    private final UUID id;
    private String title;
    private String description;
    private final LocalDateTime createdAt;
    private boolean isDone;
    private String tag;

    public Todo(String title, String description, String tag) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.createdAt = LocalDateTime.now();
        this.isDone = false;
        this.tag = tag;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
