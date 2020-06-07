package com.quickShift.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static String url = "jdbc:mysql://Localhost:3306/quickshiftdb";
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String password = "340391@mySQL";
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found.");
        }
        System.out.println("connection status: success");
        return con;
    }
}