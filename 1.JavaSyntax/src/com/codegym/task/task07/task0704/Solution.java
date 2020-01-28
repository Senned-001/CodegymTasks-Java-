package com.codegym.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Flip the array

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] c = new int[10];
        for(int i=0;i<10;i++)
            c[i]=Integer.parseInt(reader.readLine());
        for(int i=9;i>=0;i--)
            System.out.println(c[i]);
        reader.close();
    }
}

