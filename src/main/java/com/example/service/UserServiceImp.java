package com.example.service;

import com.example.handlers.TableFastQuery;
import com.example.handlers.Configs;
import com.example.model.User;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{
    @NotNull
    @Override
    public List<User> findAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        ResultSet rsmd = conectFromDB().executeQuery(TableFastQuery.getALL("users","id_user","name","password","date_create_account"));
        while(rsmd.next())
        {
            int id = rsmd.getInt(1);
            String name = rsmd.getString(2);
            String password = rsmd.getString(3);
            String date = rsmd.getString(4);
            User user = new User(id,name,password,date);
            //System.out.println(user);
            users.add(user);
        }
        return users;
    }

    @Override
    public @NotNull User findByKey(int id) throws SQLException {
        ResultSet rsmd = conectFromDB().executeQuery(TableFastQuery.getFromKey("users","id_user", String.valueOf(id)));
        if(rsmd.next()) {
            int newId = rsmd.getInt(1);
            String name = rsmd.getString(2);
            String password = rsmd.getString(3);
            String date = rsmd.getString(4);
            User user = new User(newId, name, password, date);
            return user;
        }
        else {return null;}
    }

    @Override
    public User createUser(User request) throws SQLException {
        //System.out.println(request.getNameUser());
        ResultSet rsmd = conectFromDB().executeQuery(TableFastQuery.addData("users","id_user","name",
                "password","date_create_account",request.getId(),request.getNameUser(),request.getPassword(),request.getDateCreateAccount()));
        if(rsmd.next()) {
            return new User(request.getId(), request.getNameUser(), request.getPassword(), request.getDateCreateAccount());
        }
        else {
            return null;
        }
    }

    @Override
    public User updateUser(int id, User user) throws SQLException {
        ResultSet rsmd= conectFromDB().executeQuery(TableFastQuery.updateData("users","name","password",
                "date_create_account",user.getNameUser(),user.getPassword(),user.getDateCreateAccount(),"id_user",id));
        if(rsmd.next())
        {
            return user;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        boolean rsmd = conectFromDB().executeQuery(TableFastQuery.deleteData("users","id_user",id)).next();
    }

    private Statement conectFromDB() throws SQLException {
        Connection connection = DriverManager.getConnection(
                Configs.DB_URL,
                Configs.USER,
                Configs.DB_PASSWORD
        );
        Statement st = connection.createStatement();
        return st;
    }
}
