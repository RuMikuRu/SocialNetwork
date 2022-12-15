package com.example.model;

import lombok.Data;

import java.util.Date;

@Data
public class CreateUserRequest {
    private int id;

    private String nameUser;

    private String password;

    private String dateCreateAccount;
}
