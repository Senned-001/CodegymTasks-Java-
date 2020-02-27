package com.codegym.task.task27.task2712.kitchen;

import com.codegym.task.task27.task2712.ConsoleHelper;
import com.codegym.task.task27.task2712.statistics.StatisticsManager;
import com.codegym.task.task27.task2712.statistics.event.OrderReadyEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private String name;
    private StatisticsManager statisticsManager = StatisticsManager.getInstance();

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable observable, Object arg) {
        Order order = (Order)arg;
        ConsoleHelper.writeMessage("Start cooking - " + arg + ", cooking time " + order.getTotalCookingTime() + " min");
        setChanged();
        statisticsManager.record(new OrderReadyEventDataRow(observable.toString(), this.toString(),order.getTotalCookingTime(),order.getDishes()));
        notifyObservers(arg);
    }
}
