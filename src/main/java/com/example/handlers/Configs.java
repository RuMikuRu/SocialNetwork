package com.example.handlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public interface Configs {
    String DB_URL = "jdbc:postgresql://localhost:5432/socialNetwork";
    String USER = "postgres";
    String DB_PASSWORD = "admin";

    String DB_SCHEMA = "schema.sql";
    String DB_DATA  = "data.sql";

    public static Statement conectFromDB() throws SQLException {
        Connection connection = DriverManager.getConnection(
                Configs.DB_URL,
                Configs.USER,
                Configs.DB_PASSWORD
        );
        Statement st = connection.createStatement();
        return st;
    }
}
