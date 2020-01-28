package com.codegym.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Ascending numbers

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] m=new int[5];
        for(int i=0;i<5;i++)
        m[i]=Integer.parseInt(reader.readLine());
        int a;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++) {
                if (m[i] < m[j]) {
                    a = m[i];
                    m[i] = m[j]
                    ;
                    m[j] = a;
                }
            }
        }
        for(int i=0;i<5;i++)
            System.out.println(m[i]);
        reader.close();
    }
}
