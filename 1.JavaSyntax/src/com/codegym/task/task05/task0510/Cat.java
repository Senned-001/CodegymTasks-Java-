package com.codegym.task.task05.task0510;

/* 
Initializing cats

*/

public class Cat {
    String name=null, color, address=null;
    int weight, age;
    String colordefault =  "grey";
    int weightdefault = 3, agedefault = 3;

    public void initialize(String name){
        this.name = name;

        this.color = this.colordefault;
        this.weight = this.weightdefault;
        this.age = this.agedefault;
    }

    public void initialize(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;

        this.color = this.colordefault;
    }

    public void initialize(String name, int age){
        this.name = name;
        this.age = age;

        this.color = this.colordefault;
        this.weight = this.weightdefault;
    }

    public void initialize(int weight, String color){
        this.color = color;
        this.weight = weight;

        this.age = this.agedefault;
    }

    public void initialize(int weight, String color, String address){
        this.color = color;
        this.weight = weight;
        this.address = address;

        this.age = this.agedefault;
    }

    public static void main(String[] args) {

    }
}
