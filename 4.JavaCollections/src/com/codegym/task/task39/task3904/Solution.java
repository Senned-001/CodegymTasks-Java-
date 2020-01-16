package com.codegym.task.task39.task3904;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Stairs

*/
public class Solution {
    private static int n = 70;
    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        //numbers of Tribonachi
        if (n<0) return 0;
        if (n==0)return 1;
        ArrayList<Long> result=new ArrayList<>();
        result.add(1L);
        result.add(1L);
        result.add(2L);
        for(int i=3;i<=n;i++){
            result.add(result.get(i-1)+result.get(i-2)+result.get(i-3));
        }
        return result.get(result.size()-1);
    }
}
