package com.codegym.task.task25.task2506;

/* 
Monitoring thread state

*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread();
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);

        loggingStateThread.start(); // NEW
        Thread.sleep(100);
        target.start();  // RUNNABLE
        Thread.sleep(100);
        // TERMINATED
    }
}
