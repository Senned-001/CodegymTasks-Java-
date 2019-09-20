package com.codegym.task.task04.task0428;

/* 
Positive number

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int kol=0;
        if (a>0) kol++;
        if (b>0) kol++;
        if (c>0) kol++;
        System.out.println(kol);


    }
}
