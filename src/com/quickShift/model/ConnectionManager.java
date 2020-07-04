package com.quickShift.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static String url = "jdbc:mysql://Localhost:3306/quickshiftdb";
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String password = "340391@mySQL";
    private static Connection con = null;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
                if(con == null){
                    throw new SQLException("\"Failed to create the database connection.\"");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found.");
        }
        //System.out.println("connection status: success");
        return con;
    }
}