package com.example.product;

import java.util.Date;

public class Vehicle {
    private String vehicleId;
    private String vehicleNumber;
    private String model;
    private String vehicleBrand;
    private Date manufacturedYear;
    private long kmRan;

    public Vehicle(){

    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", model='" + model + '\'' +
                ", vehicleBrand='" + vehicleBrand + '\'' +
                ", manufacturedYear=" + manufacturedYear +
                ", kmRan=" + kmRan +
                ", isActive=" + isActive +
                ", numberOfSeats=" + numberOfSeats +
                '}';
    }

    private boolean isActive = true;
    private int numberOfSeats;

    public Vehicle(String vehicleId){
        this.vehicleId = vehicleId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public Date getManufacturedYear() {
        return manufacturedYear;
    }

    public void setManufacturedYear(Date manufacturedYear) {
        this.manufacturedYear = manufacturedYear;
    }

    public long getKmRan() {
        return kmRan;
    }

    public void setKmRan(long kmRan) {
        this.kmRan = kmRan;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
