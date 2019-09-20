package com.codegym.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.Collections;
/* 
In decreasing order

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

    }

    public static void sort(int[] array) {
        int t=0;
        for(int i = 0;i<array.length;i++)
            for (int j=0;j<array.length-1;j++)
                if (array[j]<array[j+1]) {t=array[j]; array[j]= array[j+1];array[j+1]=t;}


        for (int x : array)
            System.out.println(x);
    }
}
