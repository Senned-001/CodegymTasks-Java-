package com.codegym.task.task05.task0507;

/* 
Arithmetic mean

*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        double count = 0;
        int a=0;

        while (true) {
            a = Integer.parseInt(reader.readLine());
            if (a==-1)
                break;
            sum += a;
            count++;
        }
        double arif = sum / count;
        System.out.println(arif);
        reader.close();
    }

}