package com.example;

import com.example.product.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private String storeId;
    private VehicleInventory vehicleInventory;
    private List<Reservation> reservations;
    private Location location;

    @Override
    public String toString() {
        return "Store{" +
                "storeId='" + storeId + '\'' +
                ", vehicleInventory=" + vehicleInventory +
                ", reservations=" + reservations +
                ", location=" + location +
                '}';
    }

    public void setVehicleInventory(VehicleInventory inventory){
        this.vehicleInventory = inventory;
        this.reservations = new ArrayList<>();
    }

    public Reservation reserveVehicle(Vehicle vehicle, User user){
        Reservation reservation = new Reservation(user, vehicle);
        this.reservations.add(reservation);
        return reservation;
    }

    public Store(String storeId, Location location){
        this.storeId = storeId;
        this.location = location;
    }

    public void addReservation(Reservation reservation){
        this.reservations.add(reservation);
    }

    public Vehicle getVehicle(){
        //sample id
        return vehicleInventory.getVehicle("eehe22");
    }

}
