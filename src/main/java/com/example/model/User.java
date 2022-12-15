package com.example.model;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User{
    private int id;

    private String nameUser;

    private String password;

    private String dateCreateAccount;

    public User(int id, String nameUser, String password, String dateCreateAccount) {
        this.id = id;
        this.nameUser = nameUser;
        this.password = password;
        this.dateCreateAccount = dateCreateAccount;
    }
    User()
    {
        super();
    }
}
