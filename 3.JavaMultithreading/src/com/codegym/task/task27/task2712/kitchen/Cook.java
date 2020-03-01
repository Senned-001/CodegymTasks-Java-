package com.codegym.task.task27.task2712.kitchen;

import com.codegym.task.task27.task2712.ConsoleHelper;
import com.codegym.task.task27.task2712.statistics.StatisticsManager;
import com.codegym.task.task27.task2712.statistics.event.OrderReadyEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable{
    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue;

    public Cook(String name) {
        this.name = name;
    }

    public void setQueue(LinkedBlockingQueue<Order> orderQueue) {
        this.queue = orderQueue;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        while(true) {
            if(!queue.isEmpty()) {
                if (!isBusy()&&!queue.isEmpty())
                    this.startCookingOrder(queue.poll());
            }
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
            }
        }
    }

    public void startCookingOrder(Order order){
        busy=true;
        StatisticsManager statisticsManager = StatisticsManager.getInstance();
        statisticsManager.record(new OrderReadyEventDataRow(order.getTablet().toString(), this.toString(),order.getTotalCookingTime(),order.getDishes()));
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + " min");
        try {
            Thread.sleep(order.getTotalCookingTime()*10);
        } catch (InterruptedException e) {
        }
        setChanged();
        notifyObservers(order);
        busy=false;
    }

    public boolean isBusy() {
        return busy;
    }
}
