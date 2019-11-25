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
        dishes = ConsoleHelper.getAllDishesForOrder();
        ConsoleHelper.writeMessage(this.toString());
    }

    public int getTotalCookingTime() {
        return dishes.stream().mapToInt(Dish::getDuration).reduce(0, (d1, d2) -> d1 + d2);
    }

    @Override
    public String toString() {
        if (dishes == null || dishes.isEmpty())
            return "";
        else
            return "Your order: " + dishes + " from " + tablet;
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }
}
