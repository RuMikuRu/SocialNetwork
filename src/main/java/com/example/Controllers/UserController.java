package com.example.Controllers;


import com.example.model.User;
import com.example.service.userService.UserService;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@CrossOrigin
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
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

    @PatchMapping(value = "/{userId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public User update(@PathVariable Integer userId, @RequestBody User request) throws SQLException {
        return userService.updateUser(userId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{userId}", produces = APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer userId) throws SQLException {
        userService.deleteUser(userId);
    }
}
