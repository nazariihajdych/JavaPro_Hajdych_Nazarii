package com.hillel.hajdych.homeworks.hw22.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String host = System.getenv("JDBC_HOST");
            String dbName = System.getenv("JDBC_DB_NAME");
            String user = System.getenv("JDBC_USER");
            String password = System.getenv("JDBC_PASSWORD");

            String url = String.format("%s/%s", host, dbName);

            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver class not found");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
