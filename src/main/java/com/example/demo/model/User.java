package com.example.demo.model;

import com.example.demo.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
//@AllArgsConstructor
public class User {
    private Long id;
    private String username;

    public static  User toModel(UserEntity entity) {
        User model = new User();
        model.id = entity.getId();
        model.username = entity.getUsername();
        return  model;

    }


}
