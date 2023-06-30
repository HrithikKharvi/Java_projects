package com.example.components.systemStates;

import com.example.components.VendingMachine;
import com.example.components.produts.Product;

public class InitialState implements SystemState{
    VendingMachine machine;

    public InitialState(VendingMachine machine){
        this.machine = machine;
    }

    @Override
    public void insertMode() {
        System.out.println("Please proceed with inserting the coins");
        machine.setMode(new InsertState(machine));
    }

    @Override
    public void insertCoin(double coins) throws Exception{
        throw new Exception("Pleas switch to the insert mode to do this task!");
    }

    @Override
    public void dialMode() throws Exception{
        throw new Exception("You are not allowed to do this action");
    }

    @Override
    public void cancel() throws Exception{
        System.out.println("Cancelling the transaction!");
    }

    @Override
    public void finalizeCode(int code) throws Exception {
        throw new Exception("You cannot perform this action now!");
    }

    @Override
    public void dialCode(int code) throws Exception {
        throw new Exception("Please insert amount and select the product before doing this action");
    }

    @Override
    public Product dispenseProduct(int code) throws Exception{
        throw new Exception("Please insert amount and select the product before doing this action");
    }

    @Override
    public void refund() throws Exception {
        throw new Exception("Cannot perform this action before inserting the coin!");
    }
}
