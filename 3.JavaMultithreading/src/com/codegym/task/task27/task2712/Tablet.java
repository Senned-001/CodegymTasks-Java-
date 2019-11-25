package com.codegym.task.task27.task2712;

import com.codegym.task.task27.task2712.ad.AdvertisementManager;
import com.codegym.task.task27.task2712.ad.NoVideoAvailableException;
import com.codegym.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private static final Logger logger = Logger.getLogger(Tablet.class.getName());
    final int number;

    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
        } catch (IOException ioe) {
            logger.log(Level.SEVERE, "The console is unavailable.");
        }
        if (!order.isEmpty()) {
            setChanged();
            notifyObservers(order);
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
}
