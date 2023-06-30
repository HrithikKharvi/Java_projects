package com.example.components.systemStates;

import com.example.components.VendingMachine;
import com.example.components.produts.Product;

public class InsertState implements SystemState{

    VendingMachine machine;
    public InsertState(VendingMachine machine){
        this.machine = machine;
    }
    @Override
    public void insertMode() throws Exception {
        System.out.println("Currently in inserting mode, please proceed inserting the amount!");
    }

    @Override
    public void insertCoin(double coin) throws Exception {
        machine.getAmountList().add(coin);
        System.out.println("Inserted " + coin);
    }

    @Override
    public void dialMode() throws Exception {
        System.out.println("Please enter your code for the product using the dial pad");
        this.machine.setMode(new DialState(machine));
    }

    @Override
    public void dialCode(int code) throws Exception {
        throw new Exception("Please complete inserting coins and then move to dial Mode");
    }

    @Override
    public void cancel() throws Exception {
        refund();
        System.out.println("Cancelling the transaction!");
        machine.setMode(new InitialState(machine));
    }

    @Override
    public void finalizeCode(int code) throws Exception {
        throw new Exception("Please finish inserting the coin and selecting the product code!");
    }

    @Override
    public Product dispenseProduct(int code) throws Exception {
        throw new Exception("Please complete inserting coin and selecting the product before doing this action");
    }

    @Override
    public void refund() throws Exception {
        double totInsertedAmount = machine.getTotalInsertedAmount();
        System.out.println("Please collect "+ totInsertedAmount +" amount at the cash dispenser");
    }
}
