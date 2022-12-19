package com.example.service.userService;

import com.example.handlers.TableFastQuery;
import com.example.model.User;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.handlers.Configs.connectFromDB;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    @NotNull
    @Override
    public List<User> findAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        ResultSet rsmd = connectFromDB().executeQuery(TableFastQuery.getALL("users","id_user","name","password","date_create_account"));
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
        rsmd.close();
        return users;
    }

    @Override
    public @NotNull User findByKey(int key) throws SQLException {
        ResultSet rsmd = connectFromDB().executeQuery(TableFastQuery.getFromKey("users","id_user", String.valueOf(key)));
        if(rsmd.next()) {
            int id = rsmd.getInt(1);
            String name = rsmd.getString(2);
            String password = rsmd.getString(3);
            String date = rsmd.getString(4);
            User user = new User(id, name, password, date);
            rsmd.close();
            return user;
        }
        else {rsmd.close();
            return null;}
    }

    @Override
    public @NotNull User createUser(@NotNull User request) throws SQLException {
        //System.out.println(request.getNameUser());
        ResultSet rsmd = connectFromDB().executeQuery(TableFastQuery.addData("users","id_user","name",
                "password","date_create_account",request.getId(),request.getNameUser(),request.getPassword(),request.getDateCreateAccount()));
        if(rsmd.next()) {
            rsmd.close();
            return new User(request.getId(), request.getNameUser(), request.getPassword(), request.getDateCreateAccount());
        }
        else {
            return null;
        }
    }

    @Override
    public @NotNull User updateUser(int id, @NotNull User user) throws SQLException {
        ResultSet rsmd= connectFromDB().executeQuery(TableFastQuery.updateData("users","name","password",
                "date_create_account",user.getNameUser(),user.getPassword(),user.getDateCreateAccount(),"id_user",id));
        if(rsmd.next())
        {
            rsmd.close();
            return user;
        }
        else
        {
            rsmd.close();
            return null;
        }
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        boolean rsmd = connectFromDB().executeQuery(TableFastQuery.deleteData("users","id_user",id)).next();
    }
}
