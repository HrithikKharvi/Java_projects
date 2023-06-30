package com.example.components.systemStates;

import com.example.components.VendingMachine;
import com.example.components.produts.Product;

public class DialState implements SystemState{
    VendingMachine machine;

    public DialState(VendingMachine machine){
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
        System.out.println("Please enter the code for the product");
    }

    @Override
    public void dialCode(int code) throws Exception {
        if(machine.validCode(code)){
            System.out.println("Valid code, Please press the finalize button");
        }else{
            throw new Exception("Invalid code you entered!, try some other code!");
        }
    }

    @Override
    public void cancel() throws Exception {
        refund();
        System.out.println("Cancelling the transaction!");
        machine.setMode(new InitialState(machine));
    }

    @Override
    public void finalizeCode(int code) throws Exception {
        if(this.machine.getCodeAndProduct().get(code).size() <= 0){
            System.out.println("Sold out!");
            this.machine.setMode(new InitialState(this.machine));
        }
        else

        this.machine.setMode(new DispenseState(machine));
    }

    @Override
    public Product dispenseProduct(int code) throws Exception {
        return null;
    }

    @Override
    public void refund() throws Exception {
        double totInsertedAmount = machine.getTotalInsertedAmount();
        System.out.println("Please collect "+ totInsertedAmount +" amount at the cash dispenser");
    }
}
