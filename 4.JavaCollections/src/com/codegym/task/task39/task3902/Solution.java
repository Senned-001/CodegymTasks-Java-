package com.codegym.task.task39.task3902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Bits were bits

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter a number: ");
        long l = Long.parseLong(reader.readLine());
        reader.close();
        String result = isWeightEven(l) ? "even" : "odd";
        System.out.println("The entered number has " + result + "ones");
    }

    public static boolean isWeightEven(long number) {
        /*String s = Long.toString(number,2);
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') count++;
        }*/
        long count=Long.bitCount(number);
        return count%2==0;
    }
}