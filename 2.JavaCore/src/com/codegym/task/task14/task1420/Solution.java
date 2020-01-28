package com.codegym.task.task14.task1420;

/* 
GCD

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        if (a <= 0 || b <= 0)
            throw new Exception();
        reader.close();
        int min;
        int chislo = 1;
        if (a < b)
            min = a;
        else
            min = b;
        for (int i = min; i > 0; i--) {
            if ((a % i == 0) && (b % i == 0)) {
                chislo = i;
                break;
            }
        }
        System.out.println(chislo);
    }
}
