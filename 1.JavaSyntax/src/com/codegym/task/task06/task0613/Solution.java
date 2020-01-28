package com.codegym.task.task06.task0613;

/* 
Cat and statics

*/

public class Solution {
    public static void main(String[] args) {
        Cat cat;
        for (int i = 0;i<10;i++)
            cat = new Cat();
        System.out.println(Cat.catCount);
        // Display the value of the variable catCount
    }

    public static class Cat {
        static public int catCount;

        public Cat(){
            catCount++;
        }
    }
}
