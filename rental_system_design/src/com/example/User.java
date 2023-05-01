package com.example;

public class User {

    private String userId;
    private String dlID;
    private String username;

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", dlID='" + dlID + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public User(String userId, String dlID, String username){
        this.userId = userId;
        this.dlID = dlID;
        this.username = username;
    }



}
