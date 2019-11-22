package com.codegym.task.task27.task2712;

import com.codegym.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    final int number;
    static Logger logger= Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder(){
        Order order=null;
        try {
            order=new Order(this);
            setChanged();               //flag changed for Observer(Cook)
            notifyObservers(order);     //transmit object to Observer
            return order;

        } catch (IOException e) {
            logger.log(Level.SEVERE,"The console is unavailable.");
            return null;
        }

    }



    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
