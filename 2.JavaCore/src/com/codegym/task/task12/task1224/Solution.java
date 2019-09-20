package com.codegym.task.task12.task1224;

/* 
Unknown animal

*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        String s="Animal";
        if(o.getClass().getSimpleName().equals("Cat")||
                o.getClass().getSimpleName().equals("Tiger")||
                o.getClass().getSimpleName().equals("Lion")||
                o.getClass().getSimpleName().equals("Bull")||
                o.getClass().getSimpleName().equals("Pig"))
            s= o.getClass().getSimpleName();

        return s;
    }

    public static class Cat {
    }

    public static class Tiger {
    }

    public static class Lion {
    }

    public static class Bull {
    }

    public static class Pig {
    }
}
