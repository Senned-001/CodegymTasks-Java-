package com.codegym.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
One large array and two small ones

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] c = new int[20];
        int[] a = new int[10];
        int[] b = new int[10];
        for(int i=0;i<20;i++)
            c[i]=Integer.parseInt(reader.readLine());
        for(int i=0;i<10;i++){
            a[i]=c[i];
            b[i]=c[i+10];
        }
        for(int i=0;i<10;i++)
            System.out.println(b[i]);
        reader.close();
    }
}
