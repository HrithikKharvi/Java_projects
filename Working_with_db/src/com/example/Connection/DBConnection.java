package com.example.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection connection = null;

    private DBConnection(){
    }

    public static Connection getInstance(String username, String password, String host, String database){
        if(connection == null){
            String connectionString = "jdbc:mysql://" + host + ":3306/" + database;
            try {

                connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(connectionString, username, password);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

        return connection;
    }

}
