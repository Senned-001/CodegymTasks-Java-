package com.codegym.task.task35.task3501;

public class StaticGeneric {
    public static <T> T someStaticMethod(T genericObject) {
        System.out.println(genericObject);
        return genericObject;
    }
}