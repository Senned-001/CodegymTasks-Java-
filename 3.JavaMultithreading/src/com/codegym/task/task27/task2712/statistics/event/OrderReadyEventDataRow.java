package com.codegym.task.task27.task2712.statistics.event;

import com.codegym.task.task27.task2712.kitchen.Dish;

import java.util.Date;
import java.util.List;

public class OrderReadyEventDataRow implements EventDataRow{
    private String tabletName;
    private String cookName;
    private int cookingTimeSeconds;
    private List<Dish> dishesInOrder;
    private Date currentDate;

    public OrderReadyEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> dishesInOrder) {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.dishesInOrder = dishesInOrder;
        this.currentDate = new Date();
    }

    @Override
    public EventType getType(){
        return EventType.ORDER_READY;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    @Override
    public int getTime() {
        return (int)(new Date().getTime()-currentDate.getTime());
    }
}
