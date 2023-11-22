/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.todo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.todo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.todo.service.*;

@RestController
public class TodoController {

    @Autowired
    public TodoJpaService songService;

    @GetMapping("/todos")
    public ArrayList<Todo> getTodoList() {
        return songService.getTodoList();
    }

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable("id") int id) {
        return songService.getTodoById(id);
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo1) {
        return songService.addTodo(todo1);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodoById(@PathVariable("id") int id, @RequestBody Todo todo1) {
        return songService.updateTodoById(id, todo1);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable("id") int id) {
        songService.deleteTodo(id);
    }

}