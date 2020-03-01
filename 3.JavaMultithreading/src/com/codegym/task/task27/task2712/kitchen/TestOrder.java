package com.codegym.task.task27.task2712.kitchen;

import com.codegym.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() {
        this.dishes = new ArrayList<>();
        int sizeOfDishes = (int)Math.round(Math.random()/2*10);
       // System.out.println(sizeOfDishes);
        if(sizeOfDishes==0) sizeOfDishes=1;
        for(int i=0; i<sizeOfDishes; i++){
            int s=(int)(Math.random()/2*10);
            //System.out.println(Dish.values()[s]);
            dishes.add(Dish.values()[s]);

        }
    }
}
