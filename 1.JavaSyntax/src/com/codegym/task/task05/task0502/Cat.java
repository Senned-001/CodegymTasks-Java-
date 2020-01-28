package com.codegym.task.task05.task0502;

/* 
Implement the fight method

*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int s1;
        int s2;
        s1 = (this.age+this.weight)*this.strength;
        s2 = (anotherCat.age+anotherCat.weight)*anotherCat.strength;
        if (s1>s2)
            return (true);
        else return (false);
    }

    public static void main(String[] args) {
    }
}
