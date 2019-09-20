package com.codegym.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Min and max in arrays

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] m = new int[20];
        for(int i=0;i<20;i++)
            m[i]=Integer.parseInt(reader.readLine());
        int maximum=m[0];
        int minimum=m[0];

        for(int i=0;i<20;i++){
            if(m[i]>maximum) maximum = m[i];
            if(m[i]<minimum) minimum = m[i];}

        System.out.print(maximum + " " + minimum);
    }
}
