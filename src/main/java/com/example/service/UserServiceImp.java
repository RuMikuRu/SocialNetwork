package com.example.service;

import com.example.handlers.Configs;
import com.example.handlers.FastQuery;
import com.example.model.User;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{
    @NotNull
    @Override
    public List<User> findAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        ResultSet rsmd = conectFromDB();
        while(rsmd.next())
        {
            int id = rsmd.getInt(1);
            String name = rsmd.getString(2);
            String password = rsmd.getString(3);
            java.sql.Date date = rsmd.getDate(4);
            User user = new User(id,name,password,date);
            //System.out.println(user);
            users.add(user);
        }
        return users;
    }

    @Override
    public @NotNull User findByKey(int id) {
        return new User(1,"dsf","fesf", new Date(2022,12,12));
    }

    @Override
    public User createUser(int id, String name, String password, Date createdDate) {
        return new User(1,"dsf","fesf", new Date(2022,12,12));
    }

    @Override
    public User updateUser(int id, User user) {
        return new User(1,"dsf","fesf", new Date(2022,12,12));
    }

    @Override
    public User deleteUser(int id) {
        return new User(1,"dsf","fesf", new Date(2022,12,12));
    }

    private ResultSet conectFromDB() throws SQLException {
        Connection connection = DriverManager.getConnection(
                Configs.DB_URL,
                Configs.USER,
                Configs.DB_PASSWORD
        );
        Statement st = connection.createStatement();
        return st.executeQuery(FastQuery.DB_ALL_USERS);
    }
}
