package com.example;

import java.sql.Date;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {

        //Sample input test

        //Creating the userdata object to access the users table;
        UserData userData = new UserData();

        //Running the getUsers() method to get the list of records
        ResultSet rs = userData.getUsers();
        try
        {
            while(rs.next()){
                System.out.println("USER NAME: " + rs.getString(1) + "\n" +
                                    "PASSWORD: " + rs.getInt(2) + "\n" +
                                    "Date: " + rs.getDate(3).toString()
                );
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        //Inserting new user into the users table using UserData object
        userData.insertUser("Hrithik R Kharvi", 21, new Date(2023,2,4));

        //Updating the existing record by passing sql query as input to the method
        userData.update("UPDATE users SET username = 'Hrithik' where username = 'Hrithik R Kharvi'");

        //Delete the record by passing full sql query as input to the method
        userData.delete("DELETE FROM users WHERE username = 'Hrithik'");

    }
}
