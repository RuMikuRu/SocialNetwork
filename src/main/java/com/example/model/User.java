package com.example.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
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
