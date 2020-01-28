package com.codegym.task.task09.task0926;

import java.util.ArrayList;

/* 
List of number arrays

*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> list = new ArrayList<>();
        int[] indexes = {5, 2, 4, 7, 0};
        for(int i = 0; i<indexes.length;i++) {
            int[] c = new int[indexes[i]];
            for (int j = 0; j < indexes[i]; j++) {
                c[j] = j;
                list.add(c);
            }
        }
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
