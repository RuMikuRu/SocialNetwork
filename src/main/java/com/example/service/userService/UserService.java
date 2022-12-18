package com.example.service.userService;

import com.example.model.User;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    @NotNull
    List<User> findAllUsers() throws SQLException;

    @NotNull
    User findByKey(@NotNull int id) throws SQLException;

    @NotNull
    User createUser(User request) throws SQLException;

    @NotNull
    User updateUser(@NotNull int id,@NotNull User user) throws SQLException;

    void deleteUser(@NotNull int id) throws SQLException;
}
