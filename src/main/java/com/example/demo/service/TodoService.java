package com.example.demo.service;

import com.example.demo.entity.TodoEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.TodoRepo;
import com.example.demo.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TodoService {

    private TodoRepo todoRepo;
    private UserRepo userRepo;

    public TodoEntity createTodo(TodoEntity todo, Long userId) {
        Optional<UserEntity> user = userRepo.findById(userId);
        if(user.isEmpty()) {
            throw new UserNotFoundException("Пользователя с таким id не существует");
        }
        todo.setUser(user.get());
        return todoRepo.save(todo);
    }

    public TodoEntity completeTodo(Long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return todoRepo.save(todo);
    }


}
