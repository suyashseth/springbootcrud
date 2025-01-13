package com.exercise.crud.service;

import com.exercise.crud.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save(User user);
    Optional<User> findById(long id);
    List<User> findAll();
    long countAll();
    void deleteById(long id);

}
