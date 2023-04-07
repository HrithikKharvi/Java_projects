package com.example.gameComponent;

public class Die {

    public int dieCount;

    public Die(int count){
        this.dieCount = count;
    }

    public int rollDie(){
        int sum = 0;
        int counter = 0;

        while(counter < this.dieCount){
            sum += Math.floor(Math.random() * 6) + 1;
            counter++;
        }

        System.out.println("+--------+");
        System.out.println("|   " + sum + "    |");
        System.out.println("+--------+");

        return sum;
    }


}
