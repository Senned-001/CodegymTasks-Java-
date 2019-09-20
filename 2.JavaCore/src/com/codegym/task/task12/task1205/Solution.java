package com.codegym.task.task12.task1205;

/* 
Animal identification

*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Dog()));
        System.out.println(getObjectType(new Whale()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        if(!o.getClass().getSimpleName().equals("Cow")&&!o.getClass().getSimpleName().equals("Dog")&&!o.getClass().getSimpleName().equals("Whale"))
        return "Unknown Animal";
        else return o.getClass().getSimpleName();
    }

    public static class Cow {
    }

    public static class Dog {
    }

    public static class Whale {
    }

    public static class Pig {
    }
}
