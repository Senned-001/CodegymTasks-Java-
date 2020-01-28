package com.codegym.task.task05.task0517;

/* 
Creating cats

*/

public class Cat {
    String name=null;
    String color = "grey";
    String address=null;
    int weight=3;
    int age=3;

    public Cat(String name){
        this.name = name;
    }

    public Cat(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public Cat(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Cat(int weight, String color){
        this.color = color;
        this.weight = weight;
    }

    public Cat(int weight, String color, String address){
        this.color = color;
        this.weight = weight;
        this.address = address;
    }

    public static void main(String[] args) {
    }
}
