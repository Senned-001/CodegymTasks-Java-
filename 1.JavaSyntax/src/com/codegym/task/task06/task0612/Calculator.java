package com.codegym.task.task06.task0612;

/* 
Calculator

*/

public class Calculator {
    public static int plus(int a, int b) {
        int sum = a+b;
        return sum;
    }

    public static int minus(int a, int b) {
        int min = a-b;
        return min;
    }

    public static int multiply(int a, int b) {
        int mult = a*b;
        return mult;
    }

    public static double divide(int a, int b) {
        double div = a/(double)b;
        return div;
    }

    public static double percent(int a, int b) {
        double per = (double)a / 100 * b;
        return per;
    }

    public static void main(String[] args) {

    }
}