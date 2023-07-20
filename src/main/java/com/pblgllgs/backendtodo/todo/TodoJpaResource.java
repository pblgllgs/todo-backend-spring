package com.pblgllgs.backendtodo.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TodoJpaResource {

    private final TodoService service;

    private final TodoRepository todoRepository;

    public TodoJpaResource(TodoService service, TodoRepository todoRepository) {
        this.service = service;
        this.todoRepository = todoRepository;
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable("username") String username) {
        return todoRepository.findByUsername(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo retrieveTodo(@PathVariable("username") String username, @PathVariable("id") int id) {
        return todoRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("username") String username, @PathVariable("id") int id) {
        todoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public Todo updateTodo(
            @RequestBody Todo todo,
            @PathVariable("username") String username) {
        todoRepository.save(todo);
        return todo;
    }

    @PostMapping("/users/{username}/todos")
    public Todo createTodo(
            @RequestBody Todo todo,
            @PathVariable("username") String username) {
        todo.setUsername(username);
        todo.setId(null);
        return todoRepository.save(todo);
    }
}
