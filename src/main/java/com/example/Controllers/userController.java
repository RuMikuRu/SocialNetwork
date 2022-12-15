package com.example.Controllers;


import com.example.model.CreateUserRequest;
import com.example.model.User;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class userController{
    @NotNull
    private UserService userService;

    @GetMapping(value = "/all",produces = APPLICATION_JSON_VALUE)
    public List<User> getAllUser() throws SQLException {
        List<User> users = userService.findAllUsers();
        return users;
    }

    @GetMapping("fromKey/{key}")
    public User getFromKey(@PathVariable int key) throws SQLException {
        return userService.findByKey(key);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public User create(@RequestBody User request) throws SQLException {
        return userService.createUser(request);
    }
}
