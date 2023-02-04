package com.example;

import com.example.Connection.DBConnection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.*;

public class UserData {

    String host = "";
    String database = "";
    String user = "";
    String password = "";

    public void insertUser(String username, int age, Date date){
        try{
            PreparedStatement st = (PreparedStatement) DBConnection.getInstance(user, password, host, database).prepareStatement("INSERT INTO users() values(?, ?, ?)");
            st.setString(1, username);
            st.setInt(2, age);
            st.setDate(3,date);

            st.executeUpdate();
            System.out.println("Inserted new record into the table");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public ResultSet getUsers(){
        ResultSet result = null;
        try{
            String query = "SELECT * FROM users;";
            Connection connection = DBConnection.getInstance(user, password, host, database);
            Statement st = connection.createStatement();
            result = st.executeQuery(query);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return result;
    }

    public void update(String query){
        try{
            Connection connection = DBConnection.getInstance(user, password, host, database);
            Statement st = connection.createStatement();
            st.executeUpdate(query);
            System.out.println("Successfully updated the record!");
        }catch(SQLException e) {
            System.out.println("Please find the error below :- " + e.getMessage());
        }
    }


    public void delete(String query){
        try{
            Statement st = DBConnection.getInstance(user, password, host, database).createStatement();
            st.executeUpdate(query);
            System.out.println("deleted the record successfully!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
