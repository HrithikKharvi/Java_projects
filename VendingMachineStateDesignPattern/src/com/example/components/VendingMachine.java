package com.example.components;

import com.example.components.produts.Product;
import com.example.components.systemStates.InitialState;
import com.example.components.systemStates.SystemState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    Map<Integer, List<Product>> codeAndProduct;
    Map<Integer, Integer> codeAndShelf;
    List<Double> amountList;

    SystemState state;

    public VendingMachine(){
        this.state = new InitialState(this);
        this.amountList = new ArrayList<>();
        this.codeAndProduct = new HashMap<>();
        this.codeAndShelf = new HashMap<>();
    }

    public SystemState getState(){
        return this.state;
    }

    public void setMode(SystemState state){
        this.state = state;
    }

    public double getTotalInsertedAmount(){
        double tot = 0;
        for(double amt : this.amountList){
            tot += amt;
        }
        return tot;
    }

    public List<Double> getAmountList(){
        return this.amountList;
    }

    public Map<Integer, List<Product>> getCodeAndProduct(){
        return this.codeAndProduct;
    }

    public boolean validCode(int code){
        return this.codeAndProduct.containsKey(code);
    }
}
