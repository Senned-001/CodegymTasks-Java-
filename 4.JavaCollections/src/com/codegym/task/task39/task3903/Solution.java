package com.codegym.task.task39.task3903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Unequal exchange

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Please enter a number: ");

        long number = Long.parseLong(reader.readLine());
        System.out.println("Please enter the first index: ");
        int i = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the second index: ");
        int j = Integer.parseInt(reader.readLine());
        reader.close();
        System.out.println("The result of swapping bits is " + swapBits(number, i, j));
    }

    public static long swapBits(long number, int i, int j) {
        char[] charArray = Long.toString(number,2).toCharArray();
        char[] result = new char[64];           //full array of 64bit
        for(int l=0;l<64-charArray.length;l++){
            result[l]='0';
        }
        int m=0;
        for(int l=64-charArray.length;l<64;l++){
            result[l]=charArray[m];
            m++;
        }
        char temp = result[result.length-1-i];
        result[result.length-1-i]=result[result.length-1-j];
        result[result.length-1-j]=temp;
        String s=String.valueOf(result);
        return Long.valueOf(s,2);
    }
}