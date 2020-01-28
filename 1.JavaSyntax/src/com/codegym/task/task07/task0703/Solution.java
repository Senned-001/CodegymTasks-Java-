package com.codegym.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Lonely arrays interact

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = new String[10];
        int[] c = new int[10];
        for(int i=0;i<10;i++)
            s[i]= reader.readLine();
        for(int i=0;i<10;i++)
            c[i]=s[i].length();
        for(int i=0;i<10;i++)
            System.out.println(c[i]);
        reader.close();
    }
}
