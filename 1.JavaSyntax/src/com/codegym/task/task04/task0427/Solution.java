package com.codegym.task.task04.task0427;

/* 
Describing numbers

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        if ((a>=1)&&(a<=999)) {
            if ((a / 10 < 1) && (a % 2 == 0))
                System.out.println("even single-digit number");
            else if ((a / 10 < 1) && (a % 2 != 0))
                System.out.println("odd single-digit number");
            else if ((a / 10 >= 1) && (a / 10 < 10) && (a % 2 == 0))
                System.out.println("even two-digit number");
            else if ((a / 10 >= 1) && (a / 10 < 10) && (a % 2 != 0))
                System.out.println("odd two-digit number");
            else if ((a / 10 >= 10) && (a / 10 < 100) && (a % 2 == 0))
                System.out.println("even three-digit number");
            else if ((a / 10 >= 10) && (a / 10 < 100) && (a % 2 != 0))
                System.out.println("odd three-digit number");
        }
        reader.close();
    }
}
