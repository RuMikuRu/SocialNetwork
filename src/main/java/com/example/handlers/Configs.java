package com.example.handlers;

public interface Configs {
    String DB_URL = "jdbc:postgresql://localhost:5432/socialNetwork";
    String USER = "postgres";
    String DB_PASSWORD = "admin";

    String DB_SCHEMA = "schema.sql";
    String DB_DATA  = "data.sql";
}
