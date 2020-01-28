package com.codegym.task.task08.task0814;

import java.util.HashSet;
import java.util.Set;

/* 
Greater than 10? You're not a good fit for us

*/

public class Solution {
    public static HashSet<Integer> createSet() {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<20;i++) {
            set.add(i);
        }
        return set;
    }

    public static HashSet<Integer> removeAllNumbersGreaterThan10(HashSet<Integer> set) {
        set.removeIf(a -> a > 10);
        return set;
    }

    public static void main(String[] args) {
    }
}
