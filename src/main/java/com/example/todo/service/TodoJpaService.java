/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here

package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.todo.repository.*;
import com.example.todo.model.*;

@Service
public class TodoJpaService implements TodoRepository {

    @Autowired
    public TodoJpaRepository todoJpaRepository;

    @Override
    public ArrayList<Todo> getTodoList() {
        List<Todo> todoList = todoJpaRepository.findAll();
        ArrayList<Todo> todos = new ArrayList<>(todoList);
        return todos;
    }

    @Override
    public Todo addTodo(Todo todo1) {
        todoJpaRepository.save(todo1);
        return todo1;
    }

    @Override
    public Todo getTodoById(int id) {
        try {
            Todo todo1 = todoJpaRepository.findById(id).get();
            return todo1;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Todo updateTodoById(int id, Todo todo1) {
        try {
            Todo newTodo = todoJpaRepository.findById(id).get();
            if (todo1.getTodo() != null) {
                newTodo.setTodo(todo1.getTodo());
            }
            if (todo1.getStatus() != null) {
                newTodo.setStatus(todo1.getStatus());
            }
            if (todo1.getPriority() != null) {
                newTodo.setPriority(todo1.getPriority());
            }
            todoJpaRepository.save(newTodo);
            return newTodo;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteTodo(int id) {
        try {
            todoJpaRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
