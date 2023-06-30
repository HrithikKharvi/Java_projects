package com.example.components.systemStates;

import com.example.components.VendingMachine;
import com.example.components.produts.Product;

public class DispenseState implements SystemState{

    VendingMachine machine;
    public DispenseState(VendingMachine machine){
        this.machine = machine;
    }

    @Override
    public void insertMode() throws Exception {
        throw new Exception("Not allowed to do this action!");
    }

    @Override
    public void insertCoin(double amount) throws Exception {
        throw new Exception("Not allowed to do this action");
    }

    @Override
    public void dialMode() throws Exception {
        throw new Exception("You are not allowed to do this action");
    }

    @Override
    public void dialCode(int code) throws Exception {
        throw new Exception("You are not allowed to do this action");
    }

    @Override
    public void cancel() throws Exception {
        refund();
        System.out.println("Cancelling the transaction!");
        machine.setMode(new InitialState(machine));
    }

    @Override
    public void finalizeCode(int code) throws Exception {
        throw new Exception("Cannot perform this action now!");
    }

    @Override
    public Product dispenseProduct(int code) throws Exception {
        double insertedCoins = this.machine.getTotalInsertedAmount();
        Product product = this.machine.getCodeAndProduct().get(code).get(0);
        if(insertedCoins < product.getPrice()){
            System.out.println("Insufficient coins inserted");
            this.machine.setMode(new InitialState(this.machine));
            cancel();
            return null;
        }

        return this.machine.getCodeAndProduct().get(code).remove(0);
    }

    @Override
    public void refund() throws Exception {
        double totInsertedAmount = machine.getTotalInsertedAmount();
        System.out.println("Please collect "+ totInsertedAmount +" amount at the cash dispenser");
    }
}
