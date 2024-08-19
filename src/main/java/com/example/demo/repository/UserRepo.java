package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Long> {
//public interface UserRepo extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
//    Optional<UserEntity> findById(Long id);
}
