package com.codegym.task.task04.task0416;

/* 
Crossing the road blindly

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double t =Double.parseDouble(reader.readLine());
        if (((t%5)>=0)&&((t%5)<3)) System.out.println("green");
            else if (((t%5)>=3)&&((t%5)<4)) System.out.println("yellow");
                else System.out.println("red");
    }
}