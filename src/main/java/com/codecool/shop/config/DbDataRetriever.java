package com.codecool.shop.config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbDataRetriever {
    private Connection connection;
    private ResultSet resultSet;

    public DbDataRetriever(Connection connection) {
        this.connection = connection;
    }

    public void retrieveSuppliers() throws SQLException {
        String name;
        String description;
        Statement statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM suppliers");

        while (resultSet.next()) {
            name = resultSet.getString(2);
            description = resultSet.getString(3);
        }
    }
}
