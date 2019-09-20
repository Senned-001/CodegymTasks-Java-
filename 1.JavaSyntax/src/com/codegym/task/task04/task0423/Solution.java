package com.codegym.task.task04.task0423;

/* 
Bouncer policy

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        if (age>20) System.out.println("18 is old enough");


    }
}
