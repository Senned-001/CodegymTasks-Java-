package com.codegym.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Streets and houses

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] c = new int[15];
        for(int i=0;i<15;i++)
            c[i]=Integer.parseInt(reader.readLine());
        int sum1=0, sum2=0;
        for(int i=0;i<15;i++){
            if((i%2==0)||(i==0))
                sum2=sum2+c[i];
            else
                sum1=sum1+c[i];
        }
        if(sum1>sum2)
            System.out.println("Odd-numbered houses have more residents.");
        else
            System.out.println("Even-numbered houses have more residents.");
        reader.close();
    }
}
