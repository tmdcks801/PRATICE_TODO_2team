package com.codeit.todoapidesign;
import java.time.LocalDateTime;
import java.util.UUID;

public class Todo {
    private UUID id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private boolean isDone;
    private String tag;

    public Todo(String title, String description,
                boolean isDone, String tag){
        this.id = UUID.randomUUID();
        this.title = title;
        this.description =description;
        this.createdAt = LocalDateTime.now();
        this.isDone = isDone;
        this.tag = tag;
    }

    public UUID getId(){ return this.id; }
    public String getTitle(){return this.title;}
    public String getTag(){return this.tag; }
}
