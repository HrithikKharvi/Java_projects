package com.example;

public class Bill {
    private String billId;
    private Reservation reservation;
    private boolean isPaid = false;

    public Bill(String billId, Reservation reservation){
        this.billId = billId;
        this.reservation = reservation;
    }


    public void makePaid(){
        this.isPaid = true;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId='" + billId + '\'' +
                ", reservation=" + reservation +
                ", isPaid=" + isPaid +
                '}';
    }
}
