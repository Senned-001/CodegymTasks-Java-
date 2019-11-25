package com.codegym.task.task27.task2712;

import com.codegym.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> selectedDishes = new ArrayList<>();
        writeMessage("We have these dishes: " + Dish.allDishesToString());
        writeMessage("Please, select which of these you want to order:");
        String command;
        while (!(command = readString()).equals("exit")) {
            final String searchString = command;
            if (Stream.of(Dish.values()).anyMatch(x -> x.toString().equals(searchString))) {
                selectedDishes.add(Dish.valueOf(command));
            } else {
                writeMessage(command + " is not on menu, please, choose another dish:");
            }
        }
        return selectedDishes;
    }
}
