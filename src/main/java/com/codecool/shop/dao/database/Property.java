package com.codecool.shop.dao.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Property {
    public static java.util.Properties loadProperties() {
        try (InputStream inputStream = new FileInputStream("src/main/resources/connection.properties")) {
            java.util.Properties properties = new java.util.Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
