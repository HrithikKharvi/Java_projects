package com.example;

import com.example.components.VendingMachine;
import com.example.components.produts.Product;
import com.example.components.produts.ProductType;
import com.example.components.systemStates.SystemState;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception{

        Product product1 = new Product(ProductType.Pepsi, 20, 100);
        Product product2 = new Product(ProductType.Pepsi, 20, 101);
        Product product3 = new Product(ProductType.Pepsi, 20, 102);
        List<Product> list1 = new ArrayList<>();
        List<Product> list2 = new ArrayList<>();
        List<Product> list3 = new ArrayList<>();

        list1.add(product1);
        list2.add(product2);
        list3.add(product3);

        VendingMachine machine = new VendingMachine();
        machine.getCodeAndProduct().put(100, list1);
        machine.getCodeAndProduct().put(101, list2);
        machine.getCodeAndProduct().put(102, list3);


        SystemState state = machine.getState();

        state.insertMode();

        state = machine.getState();
        state.insertCoin(20.9);

        state.dialMode();

        state = machine.getState();

        state.dialCode(101);
        state.finalizeCode(101);

        state = machine.getState();
        Product product = state.dispenseProduct(101);
        System.out.println(product.getProductCode() + "->" + product.getPrice());

    }
}
