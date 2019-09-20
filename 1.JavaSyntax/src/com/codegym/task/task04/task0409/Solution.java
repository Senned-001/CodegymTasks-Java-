package com.codegym.task.task04.task0409;

/* 
Closest to 10

*/

public class Solution {
    public static void main(String[] args) {
        displayClosestToTen(8, 11);
        displayClosestToTen(7, 13);
    }

    public static void displayClosestToTen(int a, int b) {
        if (abs(10-a)>abs(10-b)) System.out.println(b);
            else if (abs(10-a)<abs(10-b)) System.out.println(a);
               else System.out.println(a);

    }

    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }
}