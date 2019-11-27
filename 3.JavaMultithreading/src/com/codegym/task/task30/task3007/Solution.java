package com.codegym.task.task30.task3007;

/* 
Let's find the highest power of 2

*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(maxPowerOf2(140_000));   // 131072
        System.out.println(maxPowerOf2(1026));      // 1024
        System.out.println(maxPowerOf2(17));        // 16
    }

    public static int maxPowerOf2(int x) {
        x |= x >> 1;
        x |= x >> 2;
        x |= x >> 4;
        x |= x >> 8;
        x |= x >> 16;
        return x &= ~x >> 1;
    }
}