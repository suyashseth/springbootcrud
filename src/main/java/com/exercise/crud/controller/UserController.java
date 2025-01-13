package com.exercise.crud.controller;

import com.exercise.crud.model.User;
import com.exercise.crud.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id) {
        System.out.println(id);
        return userService.findById(id).get();
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> all = userService.findAll();
        return ResponseEntity.ok(all);
    }

}
