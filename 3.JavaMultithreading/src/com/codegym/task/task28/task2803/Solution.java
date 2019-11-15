package com.codegym.task.task28.task2803;

import java.util.concurrent.ThreadLocalRandom;

/* 
ThreadLocalRandom

*/
public class Solution {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        ThreadLocalRandom s=ThreadLocalRandom.current();

        return s.nextInt(from,to);
    }

    public static double getRandomDouble() {
        ThreadLocalRandom s=ThreadLocalRandom.current();
        return s.nextDouble();
    }

    public static long getRandomLongBetween0AndN(long n) {
        ThreadLocalRandom s=ThreadLocalRandom.current();
        return s.nextLong(0,n);
    }

    public static void main(String[] args) {
    }
}
