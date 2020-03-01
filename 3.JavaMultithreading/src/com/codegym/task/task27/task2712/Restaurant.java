package com.codegym.task.task27.task2712;

import com.codegym.task.task27.task2712.kitchen.Cook;
import com.codegym.task.task27.task2712.kitchen.Dish;
import com.codegym.task.task27.task2712.kitchen.Order;
import com.codegym.task.task27.task2712.kitchen.Waiter;
import com.codegym.task.task27.task2712.statistics.StatisticsManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATION_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue=new LinkedBlockingQueue<>();

    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        Cook cook = new Cook("Amigo");
        cook.setQueue(orderQueue);
        Cook cook2 = new Cook("Sasha");
        cook2.setQueue(orderQueue);

        List<Tablet>listOfTablets = new ArrayList<>();
        for(int i = 0;i < 5;i++) {
            listOfTablets.add(new Tablet(i));
        }

        Thread tCook =new Thread(cook);
        Thread tCook2 =new Thread(cook2);
        tCook.start();
        tCook2.start();

        Waiter waiter = new Waiter();
        Waiter waiter2 = new Waiter();
        cook.addObserver(waiter);
        cook2.addObserver(waiter2);
        //tablet.createOrder();

        RandomOrderGeneratorTask randomOrderGeneratorTask = new RandomOrderGeneratorTask(listOfTablets, ORDER_CREATION_INTERVAL);
        Thread t = new Thread(randomOrderGeneratorTask);
        t.start();
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
        }
        t.interrupt();

        ManagerTablet managerTablet = new ManagerTablet();
        managerTablet.printActiveVideoSet();
        managerTablet.printAdRevenue();
        managerTablet.printArchivedVideoSet();
        managerTablet.printCookUtilization();


    }
}
