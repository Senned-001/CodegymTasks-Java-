package com.codegym.task.task27.task2712.kitchen;


public enum  Dish {
    Fish (25),
    Steak (30),
    Soup (15),
    Juice (5),
    Water (3);

    private int duration;

    public static String allDishesToString() {
        StringBuilder stringBuilder = new StringBuilder();
        boolean firstValue = true;
        for (Dish dish : Dish.values()) {
            stringBuilder.append(firstValue ? "" : ", ").append(dish.toString());
            firstValue = false;
        }
        return stringBuilder.toString();
    }

    public int getDuration() {
        return duration;
    }

    private Dish(int duration) {
        this.duration = duration;
    }
}
