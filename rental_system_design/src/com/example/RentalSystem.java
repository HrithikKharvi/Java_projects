package com.example;

import java.util.ArrayList;
import java.util.List;

public class RentalSystem {

    private List<User> users;
    private List<Store> stores;

    public RentalSystem(){
        this.users = new ArrayList<>();
        this.stores = new ArrayList<>();
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public List<User> getUsers(){
        return this.users;
    }

    public List<Store> getStores(){
        return this.stores;
    }

    public void addStore(Store store){
        this.stores.add(store);
    }

    public Store findNearStore(Location location){
        return stores.get(0);
    }

    public void removeUser(String userId){
        //code to delete the user
    }

    public void removeStore(String storeId){
        //code to delete the user
    }

}
