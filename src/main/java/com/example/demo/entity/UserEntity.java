package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

//psql -h localhost -p 5432 -U spring_user -d spring

@Entity
@Getter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<TodoEntity> todos;

}
