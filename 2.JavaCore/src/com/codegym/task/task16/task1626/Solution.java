package com.codegym.task.task16.task1626;

public class Solution {
    public static  int number = 5;

    public static void main(String[] args) {
        new Thread(new CountdownRunnable(), "Decrease").start();
        new Thread(new CountUpRunnable(), "Increase").start();
    }

    public static class CountUpRunnable implements Runnable{
        //write your code here
        private int countdownIndex=1;

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countdownIndex++;
                    Thread.sleep(500);
                    if (countdownIndex > Solution.number) return;
                }
            } catch (InterruptedException e) {
            }
        }

        @Override
        public String toString() {
            return Thread.currentThread().getName() + ": " + countdownIndex;
        }
    }


    public static class CountdownRunnable implements Runnable {
        private int countdownIndex = Solution.number;

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countdownIndex -= 1;
                    if (countdownIndex == 0)
                        return;
                    Thread.sleep(2500);
                }
            } catch (InterruptedException e) {
            }
        }

        @Override
        public String toString() {
            return Thread.currentThread().getName() + ": " + countdownIndex;
        }
    }
}
