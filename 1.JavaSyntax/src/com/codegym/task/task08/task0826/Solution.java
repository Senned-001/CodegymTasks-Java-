package com.codegym.task.task08.task0826;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Collections;

/* 
Five winners

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }
        sort(array) ;
        reader.close();
    }

    public static void sort(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<array.length;i++) {
            list.add(array[i]);
        }
        Collections.sort(list);
        Collections.reverse(list);
        for(int i = 0; i<list.size();i++) {
            array[i] = list.get(i);
        }
        for(int i =0;i<5;i++) {
            System.out.println(list.get(i));
        }
    }
}
