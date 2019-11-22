package com.codegym.task.task27.task2712;

import com.codegym.task.task27.task2712.kitchen.Cook;

public class Restaurant {

    public static void main(String[] args) {
        Tablet tablet1=new Tablet(1);
        Cook cook = new Cook("Amigo");
        tablet1.addObserver(cook);
        for(int i=0;i<4;i++){
            tablet1.createOrder();
        }


    }
}
