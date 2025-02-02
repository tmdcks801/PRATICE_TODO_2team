package com.example.todo.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Todo {
  private final UUID id;
  private final LocalDateTime createdAt;
  private String title;
  private String description;
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
  
  public void updateTodo(String title, String description, String tag) {
    this.title = title;
    this.description = description;
    this.tag = tag;
  }
  
  public void updateStatus(boolean done) {
    isDone = done;
  }
  
  public void updateTag(String tag) {
    this.tag = tag;
  }
  
  public UUID getId() {
    return id;
  }
  
  public String getTitle() {
    return title;
  }
  
  public String getDescription() {
    return description;
  }
  
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
  
  public boolean isDone() {
    return isDone;
  }
  
  public String getTag() {
    return tag;
  }
  
}
