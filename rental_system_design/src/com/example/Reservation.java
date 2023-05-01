package com.example;

import com.example.product.Vehicle;

import java.util.Date;

public class Reservation {
    private Date reservationStartDate;
    private Date reservationEndDate;
    private Vehicle vehicle;
    private User user;
    private ReservationStatus status;

    public Reservation(User user, Vehicle vehicle){
        this.vehicle = vehicle;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationStartDate=" + reservationStartDate +
                ", reservationEndDate=" + reservationEndDate +
                ", vehicle=" + vehicle +
                ", user=" + user +
                ", status=" + status +
                '}';
    }

    public void setReservationStatus(ReservationStatus status){
        this.status = status;
    }

}
