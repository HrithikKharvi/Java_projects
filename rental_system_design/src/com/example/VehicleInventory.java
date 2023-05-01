package com.example;

import com.example.product.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventory {

    private List<Vehicle> vehicles;

    public VehicleInventory(){
        this.vehicles = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "VehicleInventory{" +
                "vehicles=" + vehicles +
                '}';
    }

    public void addVehicle(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }

    public Vehicle getVehicle(String vehicleId){
        //Without actual logic
        return this.vehicles.get(0);
    }
}
