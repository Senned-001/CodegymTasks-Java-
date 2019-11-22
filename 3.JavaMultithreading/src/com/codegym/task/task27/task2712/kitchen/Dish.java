package com.codegym.task.task27.task2712.kitchen;

import java.util.Arrays;

public enum  Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString(){

        return Arrays.toString(Dish.values());
    }

}
