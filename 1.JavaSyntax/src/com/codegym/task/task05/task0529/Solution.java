package com.codegym.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

/* 
Console-based piggy bank

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int su=0;
        while (true)
        {
            String s = buffer.readLine();
            if (s.equals("sum"))
                break;
            else su = su+Integer.parseInt(s);
        }
        System.out.println(su);
    }
}
