package com.codegym.task.task06.task0614;

import java.util.ArrayList;

/* 
Static cats

*/

public class Cat {
    public static ArrayList<Cat> cats = new ArrayList<Cat>();

    public Cat() {
    }

    public static void main(String[] args) {
        Cat cat;
        for (int i=0;i<10;i++){
            cat = new Cat();
            cats.add(cat);}
        printCats();
    }

    public static void printCats() {
        for (int i=0;i<10;i++)
        System.out.println(cats.get(i));
    }
}
