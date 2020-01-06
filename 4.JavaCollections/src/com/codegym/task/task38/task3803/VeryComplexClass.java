package com.codegym.task.task38.task3803;

/* 
Runtime exceptions (unchecked exceptions)

*/

import java.util.Date;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object obj = new Date();
        Integer int1 = (Integer) obj;
    }

    public void methodThrowsNullPointerException() {
        String a=null;
        String b="aaa";
        if(a.equals(b)) System.out.println("aaa");
    }

    public static void main(String[] args) {
        VeryComplexClass vs=new VeryComplexClass();
        vs.methodThrowsNullPointerException();
    }
}