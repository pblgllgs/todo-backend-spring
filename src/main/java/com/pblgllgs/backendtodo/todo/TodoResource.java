package com.pblgllgs.backendtodo.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
public class TodoResource {

    private final TodoService service;

    public TodoResource(TodoService service) {
        this.service = service;
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable("username") String username) {
        return service.findByUsername(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo retrieveTodo(@PathVariable("username") String username, @PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("username") String username, @PathVariable("id") int id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public Todo updateTodo(
            @RequestBody Todo todo,
            @PathVariable("username") String username,
            @PathVariable("id") int id) {
        service.updateTodo(todo);
        return todo;
    }

    @PostMapping ("/users/{username}/todos")
    public Todo createTodo(
            @RequestBody Todo todo,
            @PathVariable("username") String username) {
        return service.addTodo(username,  todo.getDescription(), todo.getTargetDate(), todo.isDone());
    }
}
