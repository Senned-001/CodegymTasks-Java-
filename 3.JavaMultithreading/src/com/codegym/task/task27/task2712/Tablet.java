package com.codegym.task.task27.task2712;

import com.codegym.task.task27.task2712.ad.AdvertisementManager;
import com.codegym.task.task27.task2712.ad.NoVideoAvailableException;
import com.codegym.task.task27.task2712.kitchen.Order;
import com.codegym.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    private static final Logger logger = Logger.getLogger(Tablet.class.getName());
    final int number;
    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
        } catch (IOException ioe) {
            logger.log(Level.SEVERE, "The console is unavailable.");
        }
        if (!order.isEmpty()) {
           // setChanged();
            //notifyObservers(order);
            queue.add(order);
            try {
                new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
            } catch (NoVideoAvailableException e) {
                logger.log(Level.INFO, "No video is available for the following order: " + order);
            }
        }
        return order;
    }

    public Tablet(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }

    public void createTestOrder(){
        TestOrder testOrder = null;
        try {
            testOrder = new TestOrder(this);
        } catch (IOException ioe) {
            logger.log(Level.SEVERE, "The console is unavailable.");
        }
        try {
            new AdvertisementManager(testOrder.getTotalCookingTime() * 60).processVideos();
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the following order: " + testOrder);
        }
    }
}
