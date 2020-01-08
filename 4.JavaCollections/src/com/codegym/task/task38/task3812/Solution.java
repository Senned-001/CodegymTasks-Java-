package com.codegym.task.task38.task3812;

/* 
Processing annotations

*/

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if(c.isAnnotationPresent(PrepareMyTest.class)){
            PrepareMyTest a=(PrepareMyTest)c.getAnnotation(PrepareMyTest.class);
            for(String s:a.fullyQualifiedNames()){
                System.out.println(s);
            }
            return true;
        }
        return false;
    }

    public static boolean printValues(Class c) {
        if(c.isAnnotationPresent(PrepareMyTest.class)){
            PrepareMyTest a=(PrepareMyTest)c.getAnnotation(PrepareMyTest.class);
            for(Class clazz:a.value()){
                System.out.println(clazz.getSimpleName());
            }
            return true;
        }
        return false;
    }
}
