package com.example.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User{
    private int id;

    private String nameUser;

    private String password;

    private Date dateCreateAccount;

    public User(int id, String nameUser, String password, Date dateCreateAccount) {
        this.id = id;
        this.nameUser = nameUser;
        this.password = password;
        this.dateCreateAccount = dateCreateAccount;
    }
}
