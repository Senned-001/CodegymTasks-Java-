package com.codegym.task.task01.task0132;

/* 
Sum of the digits of a three-digit number

*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        String str = Integer.toString(number);

        char c1 = str.charAt(0);
        char c2 = str.charAt(1);
        char c3 = str.charAt(2);


        int n1 = c1 - '0';
        int n2= c2 - '0';
        int n3 = c3 - '0';
        int sum = n1+n2+n3;
        return sum;
    }
}