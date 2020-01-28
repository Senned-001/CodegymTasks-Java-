package com.codegym.task.task04.task0426;

/* 
Labels and numbers

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        if ((a>0)&&(a%2==0)) System.out.println("Positive even number");
            else if ((a>0)&&(a%2!=0)) System.out.println("Positive odd number");
                else if ((a<0)&&(a%2!=0)) System.out.println("Negative odd number");
                    else if ((a<0)&&(a%2==0)) System.out.println("Negative even number");
                        else System.out.println("Zero");
        reader.close();
    }
}
