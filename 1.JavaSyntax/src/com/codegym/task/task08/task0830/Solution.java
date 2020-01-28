package com.codegym.task.task08.task0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
Task about algorithms

*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array1 = new String[20];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = reader.readLine();
        }
        sort(array1);
        for (String x : array1) {
            System.out.println(x);
        }
        reader.close();
    }

    public static void sort(String[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                String temp = array[i];
                String s1 = array[i];
                String s2 = array[j];
                if (isGreaterThan(s1, s2)) {
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    // String comparison method: 'a' is greater than 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
}