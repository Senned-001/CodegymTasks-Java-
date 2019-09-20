package com.codegym.task.task04.task0442;


/* 
Adding

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum=0;
        while (true) {
            int number = Integer.parseInt(reader.readLine());
            sum=sum+number;
            if (number == -1)
            break;
        }
        System.out.println(sum);
    }

}
