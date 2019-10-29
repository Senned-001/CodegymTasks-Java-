package com.codegym.task.task26.task2601;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/*
Read online about the median of a sample

*/
public class Solution {

    public static void main(String[] args) {

        /*Integer[] array={13, 8, 15, 5, 17};
        sort(array);
        for (int i=0;i<array.length;i++)
        System.out.println(array[i]);*/
    }

    public static Integer[] sort(Integer[] array) {
        // Implement the logic here
        Arrays.sort(array);
        Integer median=0;
        if(array.length%2==0) median=(array[array.length/2-1]+array[array.length/2])/2;
        else median=array[(array.length-1)/2];

        //without Comporator
        /*Integer a=0;
        for(int j=0;j<array.length;j++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (Math.abs(array[i] - median) > Math.abs(array[i + 1] - median)) {
                    a = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = a;
                } else if (Math.abs(array[i] - median) == Math.abs(array[i + 1] - median)) {
                    if (array[i] < array[i + 1]) {
                        a = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = a;
                    }
                }

            }
        }*/

        final Integer s=median;
        Comparator<Integer> compareByMed = new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return Math.abs(i1 - s) - Math.abs(i2 - s);   }
        };
        Arrays.sort(array,compareByMed);

        return array;
    }
}
