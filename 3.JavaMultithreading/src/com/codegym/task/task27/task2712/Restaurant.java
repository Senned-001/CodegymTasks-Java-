package com.codegym.task.task27.task2712;

import com.codegym.task.task27.task2712.kitchen.Cook;
import com.codegym.task.task27.task2712.kitchen.Dish;
import com.codegym.task.task27.task2712.kitchen.Waiter;

import java.io.IOException;

public class Restaurant {
    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        Cook cook = new Cook("Amigo");
        Tablet tablet = new Tablet(1);
        Waiter waiter = new Waiter();
        tablet.addObserver(cook);
        cook.addObserver(waiter);
        tablet.createOrder();
        ManagerTablet managerTablet = new ManagerTablet();
        managerTablet.printActiveVideoSet();
        managerTablet.printAdRevenue();
        managerTablet.printArchivedVideoSet();
        managerTablet.printCookUtilization();
    }
}
