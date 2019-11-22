package com.codegym.task.task27.task2712.kitchen;

import com.codegym.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Cook implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {              //metod executed when in Observable class execute notifyObservers(order)
        //Order order = (Order) arg;
        ConsoleHelper.writeMessage("Start cooking - " + arg);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
