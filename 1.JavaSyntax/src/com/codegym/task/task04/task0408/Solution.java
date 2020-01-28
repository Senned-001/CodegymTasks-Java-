package com.codegym.task.task04.task0408;

/* 
Good or bad?

*/

public class Solution {
    public static void main(String[] args) {
        compare(3);
        compare(6);
        compare(5);
    }

    public static void compare(int a) {
        if (a<5)
            System.out.printf("The number is less than 5");
        else if (a>5)
            System.out.printf("The number is greater than 5");
        else System.out.printf("The number is equal to 5");
    }
}