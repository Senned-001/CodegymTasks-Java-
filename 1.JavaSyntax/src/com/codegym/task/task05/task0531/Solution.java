package com.codegym.task.task05.task0531;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Improving functionality

*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());
        int minimum = min(a, b, c ,d,e);

        System.out.println("Minimum = " + minimum);
    }


    public static int min(int a, int b, int c, int d, int e) {
        int mas[];
        mas = new int[5];
        mas[0]=a;
        mas[1]=b;
        mas[2]=c;
        mas[3]=d;
        mas[4]=e;
        int mini=mas[0];
        for (int i=0; i<5;i++)
                   if (mas[i]<mini) mini = mas[i];

        return mini;
    }
}
