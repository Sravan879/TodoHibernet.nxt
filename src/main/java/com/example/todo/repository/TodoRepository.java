// Write your code here

// Write your code here
package com.example.todo.repository;

import com.example.todo.model.*;

import java.util.*;

public interface TodoRepository {
    ArrayList<Todo> getTodoList();

    Todo addTodo(Todo todo1);

    Todo getTodoById(int id);

    Todo updateTodoById(int id, Todo todo1);

    void deleteTodo(int id);
}