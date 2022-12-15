package com.example.service;

import com.example.model.User;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface UserService {
    @NotNull
    List<User> findAllUsers() throws SQLException;

    @NotNull
    User findByKey(@NotNull int id);

    @NotNull
    User createUser(@NotNull int id, @NotNull String name,@NotNull String password,@NotNull Date createdDate);

    @NotNull
    User updateUser(@NotNull int id,@NotNull User user);

    User deleteUser(@NotNull int id);
}
