package com.codegym.task.task27.task2712.kitchen;

import com.codegym.task.task27.task2712.ConsoleHelper;
import com.codegym.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes=ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if(dishes.size()==0) return "";
        return "Order: " +
                 dishes.toString() +" from Tablet{"+tablet+'}';
    }
}
