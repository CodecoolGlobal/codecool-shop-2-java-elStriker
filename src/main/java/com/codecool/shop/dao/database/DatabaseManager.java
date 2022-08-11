package com.codecool.shop.dao.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseManager {
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        Properties connectionProps = Property.loadProperties();
        System.out.println("trying to connect to db");
            conn = DriverManager.getConnection(
                    connectionProps.getProperty("url") +
                    connectionProps.getProperty("database"),
                    connectionProps.getProperty("user"),
                    connectionProps.getProperty("password"));
        System.out.println("Connected to database");
        return conn;
    }
}
