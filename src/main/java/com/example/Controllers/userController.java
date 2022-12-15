package com.example.Controllers;


import com.example.model.User;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class userController{
    @NotNull
    private UserService userService;

    @GetMapping(value = "/all",produces = APPLICATION_JSON_VALUE)
    public List<User> getAllUser() throws SQLException {
        List<User> users = userService.findAllUsers();
        return users;
    }

    @GetMapping("{key}")
    public User getFromKey(@PathVariable int key)
    {
        return userService.findByKey(key);
    }
}
