package com.codegym.task.task04.task0420;

/* 
Sorting three numbers

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m[];
        m = new int[3];

        m[0] = Integer.parseInt(reader.readLine());
        m[1] = Integer.parseInt(reader.readLine());
        m[2] = Integer.parseInt(reader.readLine());
        int a;
         for (int i=0;i<3;i++)      //sortirovka po ubivaniu
             for (int j=0;j<3;j++)
         if(m[i]>m[j]) {a=m[i];m[i]=m[j];m[j]=a;}
        System.out.println(m[0] + " " + m[1] + " " + m[2]);



    }
}
