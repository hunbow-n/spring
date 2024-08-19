package com.example.demo.controller;

import com.example.demo.entity.TodoEntity;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo, @RequestParam Long userId) {
        try {

            TodoEntity entity = todoService.createTodo(todo, userId);
            return ResponseEntity.ok(entity);

        } catch (UserNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка create todo");
        }
    }

    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(todoService.completeTodo(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка complete todo");
        }
    }

}
