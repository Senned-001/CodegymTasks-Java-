package com.codegym.task.task29.task2903;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadLocalRandom;

/* 
And more refactoring

*/
public class Solution {
    public static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static void main(String[] args) {
        ConcurrentMap<Integer, String> concurrentMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            new Thread(getRunnable(i, concurrentMap)).start();
        }
        sleepOneSecond();
    }

    private static void sleepOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Runnable getRunnable(final int i, final ConcurrentMap<Integer, String> concurrentMap) {
        return new Runnable() {
            @Override
            public void run() {
                final String name = "Thread #" + i;
                int randomInt = RANDOM.nextInt(20);
                String text = name + " added a entry for " + randomInt;

                // previousEntry is null for new entries
                /* Instead of setting it to null, call concurrentMap.someMethod(randomInt, text) */
                String previousEntry = concurrentMap.putIfAbsent(randomInt,text);

                if (previousEntry != null) {
                    System.out.println(name + " wants to update " + randomInt + ", but there's already " + previousEntry);
                } else {
                    System.out.println(text);
                }
            }
        };
    }
}