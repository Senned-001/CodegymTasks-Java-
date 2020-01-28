package com.codegym.task.task04.task0414;

/* 
Number of days in the year

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int x = 365, y = 366;
        if (a%400==0)
            System.out.println("Number of days in the year: "+ y);
        else if (a%100==0)
            System.out.println("Number of days in the year: "+ x);
        else if (a%4==0)
            System.out.println("Number of days in the year: " + y);
        else System.out.println("Number of days in the year: " + x);
        reader.close();
    }
}