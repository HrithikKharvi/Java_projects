package com.example;

import com.example.product.Car;
import com.example.product.Vehicle;

public class Main {

    public static void main(String[] args) {

        RentalSystem rentalSystem = new RentalSystem();
        addUsers(rentalSystem);
        Location location = new Location("KARBNG", "Bangalore", "Karnataka", "77.5946° E", "12.9716° N");
        addStores(rentalSystem);

        User user = rentalSystem.getUsers().get(0);
        Store store = rentalSystem.findNearStore(location);

        VehicleInventory vehicleInventory = new CarInventory();
        addVehiclesToInventory(vehicleInventory);
        store.setVehicleInventory(vehicleInventory);

        Vehicle vehicle = store.getVehicle();
        Reservation reservation = store.reserveVehicle(vehicle, user);
        reservation.setReservationStatus(ReservationStatus.Scheduled);
        Bill bill = new Bill("res1234", reservation);

        System.out.println(bill);

        Payment payment = new Payment(bill);
        payment.pay();

        reservation.setReservationStatus(ReservationStatus.InProcess);
        System.out.println(bill);
    }

    public static void addUsers(RentalSystem rentalSystem){
        User user = new User("202003", "DIND24243", "Hrithik R");
        rentalSystem.addUser(user);
    }

    public static void addVehiclesToInventory(VehicleInventory inventory){
        Vehicle car = new Car();
        car.setVehicleId("car2233");
        car.setVehicleBrand("Tata");
        car.setActive(true);
        car.setVehicleNumber("KA20 2923");
        inventory.addVehicle(car);
    }

    public static void addStores(RentalSystem rentalSystem){
        Location location = new Location("KARBNG", "Bangalore", "Karnataka", "77.5946° E", "12.9716° N");
        Store store = new Store("2242HG", location);
        rentalSystem.addStore(store);
    }

}
