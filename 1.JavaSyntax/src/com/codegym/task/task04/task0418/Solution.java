package com.codegym.task.task04.task0418;

/* 
Minimum of two numbers

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        if(a>b) System.out.println(b);
            else if (b>a) System.out.println(a);
                else System.out.println(b);
    }
}