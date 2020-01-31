package com.codegym.task.task16.task1617;

/* 
Countdown at the races

*/

public class Solution {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //write your code here
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        @Override
        public void run() {
            //write your code here
            try {
                while (numSeconds>0){
                    System.out.print(numSeconds+" ");
                    Thread.sleep(1000);
                    numSeconds--;
                }
                System.out.println("Go!");
            } catch (InterruptedException ignored) {
                System.out.println("Interrupted!");
            }
        }
    }
}
