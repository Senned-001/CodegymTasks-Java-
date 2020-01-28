package com.codegym.task.task12.task1225;

/* 
Visitors

*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o) {
        //write your code here
        String s="Animal";
        if(o.getClass().getSimpleName().equals("Cat")||
                o.getClass().getSimpleName().equals("Tiger")||
                o.getClass().getSimpleName().equals("Lion")||
                o.getClass().getSimpleName().equals("Bull")||
                o.getClass().getSimpleName().equals("Cow")) {
            s = o.getClass().getSimpleName();
        }
        return s;
    }

    public static class Cat extends Animal{   // <-- Class inheritance!
    }

    public static class Tiger extends Cat {
    }

    public static class Lion extends Cat {
    }

    public static class Bull extends Animal {
    }

    public static class Cow extends Animal {
    }

    public static class Animal {
    }
}
