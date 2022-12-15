package com.example;

import com.example.handlers.Configs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = DriverManager.getConnection(
                Configs.DB_URL,
                Configs.USER,
                Configs.DB_PASSWORD
        );
        Statement st = connection.createStatement();

        String data = new String (Files.readAllBytes(Path.of(Configs.DB_DATA)));

        st.execute(data);
        st.close();

        connection.close();

        SpringApplication.run(Main.class, args);
    }
}
