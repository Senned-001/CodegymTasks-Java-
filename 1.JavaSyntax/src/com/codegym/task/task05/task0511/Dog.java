package com.codegym.task.task05.task0511;

/* 
Create a Dog class

*/

public class Dog {
    String name;
    String color;
    int height;

    public void initialize (String name){
        this.name = name;
    }

    public void initialize (String name, int height){
        this.name = name;
        this.height = height;
    }

    public void initialize (String name, int height, String color){
        this.name = name;
        this.height = height;
        this.color = color;
    }

    public static void main(String[] args) {
    }
}
