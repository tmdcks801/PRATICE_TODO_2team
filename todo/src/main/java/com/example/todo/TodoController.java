package com.example.todo;

import com.example.todo.Service.Servicea;
import com.example.todo.entity.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final Servicea service;

    public TodoController(Servicea service) {
        this.service = service;
    }

    @PostMapping("/create")
    public void createTodo(@RequestBody Todo newThing) {
        service.createTodo(newThing.getTitle(), newThing.getDescription(), newThing.getTag());
    }

    @GetMapping("/readAll")
    public Todo[] readAll() {
        return service.readAll();
    }

    @GetMapping("/readTodo/{id}")
    public Todo readTodo(@PathVariable UUID id) {
        return service.readTodo(id);
    }

    @PutMapping("/update/{id}")
    public boolean update(
            @PathVariable UUID id,
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam String tag) {
        return service.update(id, title, description, tag);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable UUID id) {
        return service.delete(id);
    }

    @GetMapping("/searchTag/{title}")
    public Todo searchTag(@PathVariable String tag) {
        return service.searchTag(tag);
    }

    @GetMapping("/searchTitle/{title}")
    public Todo searchTitle(@PathVariable String title) {
        return service.searchTitle(title);
    }

    @PutMapping("/changeIsDone/{id}")
    public void changeIsDone(@PathVariable UUID id, @RequestParam Boolean done) {
        service.changeIsDone(id, done);
    }
}
