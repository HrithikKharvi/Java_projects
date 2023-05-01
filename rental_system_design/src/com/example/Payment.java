package com.example;

public class Payment {
    private String paymentId;
    private Bill bill;

    public Payment(Bill bill){
        this.bill = bill;
    }

    public void setPaymentId(String paymentId){
        this.paymentId = paymentId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", bill=" + bill +
                '}';
    }

    public double generateAmount(){
        return 100.0;
    }

    public boolean pay(){
        bill.makePaid();
        //return true if payment is done successfully
        return true;
    }

}
