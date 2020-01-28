package com.codegym.task.task15.task1518;

/* 
Static modifiers and kittens

*/

public class Solution {

    public static class Cat{
        public String name;
    }

    public static Cat cat;
    static {
        cat = new Cat();
        cat.name = "sss";
        System.out.println(cat.name);
    }

    public static void main(String[] args) {
    }
}
