package com.codegym.task.task25.task2504;

/* 
A switch for threads

*/
public class Solution {
    public static void processThreads(Thread... threads) {
        // Implement this method
        for (Thread x : threads) {

            switch (x.getState()) {

                case NEW:
                    x.start();
                    break;

                case TIMED_WAITING:
                    x.interrupt();
                    break;

                case WAITING:
                    x.interrupt();
                    break;

                case BLOCKED:
                    x.interrupt();
                    break;

                case RUNNABLE:
                    x.isInterrupted();
                    break;

                case TERMINATED:
                    System.out.println(x.getPriority());
                    break;

            }
        }
    }

    public static void main(String[] args) {
    }
}
