package com.codegym.task.task27.task2712;

import com.codegym.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader bufferedReader;

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString()throws IOException{
        bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String s=bufferedReader.readLine();
        bufferedReader.close();
        return s;
    }

    public static List<Dish> getAllDishesForOrder()throws IOException{        // asks the customer to select a dish and adds it to the list.
        writeMessage(Dish.allDishesToString());
        writeMessage("Choose yours dishes:");
        String s=null;
        List<Dish> listOfDishes = new ArrayList<>();
        while(!(s=readString()).equalsIgnoreCase("exit")){
            if(Dish.allDishesToString().contains(s)){
            listOfDishes.add(Dish.valueOf(s));
            }
            else writeMessage("There is no such dish. Choose yours dishes:");
        }
        return listOfDishes;
    }
}
