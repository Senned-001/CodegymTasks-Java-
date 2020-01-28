package com.codegym.task.task05.task0532;

import java.io.*;

/* 
Task about algorithms

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int[] mas;
        mas = new int[a];
        for (int i=0; i<a;i++)
            mas[i] = Integer.parseInt(reader.readLine());
        int maximum = mas[0];
        for (int i=0; i<a;i++)
            if (mas[i]>maximum)
                maximum = mas[i];
        System.out.println(maximum);
        reader.close();
    }
}
