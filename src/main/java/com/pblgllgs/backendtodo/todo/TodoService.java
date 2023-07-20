package com.pblgllgs.backendtodo.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "pblgllgs", "Get AWS Certified",
                LocalDate.now().plusYears(10), false));
        todos.add(new Todo(++todosCount, "pblgllgs", "Learn DevOps",
                LocalDate.now().plusYears(11), false));
        todos.add(new Todo(++todosCount, "pblgllgs", "Learn Full Stack Development",
                LocalDate.now().plusYears(12), false));
        todos.add(new Todo(++todosCount, "pblgllgs", "Get Azure Certified",
                LocalDate.now().plusYears(14), false));
        todos.add(new Todo(++todosCount, "pblgllgs", "Learn Terraform",
                LocalDate.now().plusYears(15), false));
        todos.add(new Todo(++todosCount, "pblgllgs", "Learn Docker",
                LocalDate.now().plusYears(16), false));
        todos.add(new Todo(++todosCount, "pblgllgs", "Learn Ansible",
                LocalDate.now().plusYears(17), false));
        todos.add(new Todo(++todosCount, "pblgllgs", "Learn UI/UX",
                LocalDate.now().plusYears(13), false));
        todos.add(new Todo(++todosCount, "pblgllgs", "Learn Graphql",
                LocalDate.now().plusYears(18), false));
    }

    public List<Todo> findByUsername(String username) {
        Predicate<? super Todo> predicate =
                todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public Todo addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, done);
        todos.add(todo);
        return todo;
    }

    public void deleteById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
