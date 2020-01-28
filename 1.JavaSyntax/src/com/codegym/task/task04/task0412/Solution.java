package com.codegym.task.task04.task0412;

/* 
Positive and negative numbers

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        if (a>0) {
            a=a*2;
            System.out.println(a);
        }
        else if (a<0) {
            a=a+1;
            System.out.println(a);
        }
        else System.out.println(a);
        reader.close();
    }
}