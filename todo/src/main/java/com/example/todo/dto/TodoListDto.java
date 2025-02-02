package com.example.todo.dto;

public class TodoListDto {
  private final String title;
  private final String tag;
  
  public TodoListDto(String title, String tag) {
    this.title = title;
    this.tag = tag;
  }
  
  public String getTitle() {
    return title;
  }
  
  public String getTag() {
    return tag;
  }
}
