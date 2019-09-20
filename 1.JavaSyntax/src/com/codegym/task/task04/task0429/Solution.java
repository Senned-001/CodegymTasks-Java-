package com.codegym.task.task04.task0429;

/* 
Positive and negative numbers

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int kol=0, otr=0;
        if (a>0) kol++;
            else if(a<0) otr++;
        if (b>0) kol++;
            else if(b<0) otr++;
        if (c>0) kol++;
            else if(c<0) otr++;
        System.out.println("Number of negative numbers: "+otr);
        System.out.println("Number of positive numbers: "+kol);

    }
}
