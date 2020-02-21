package com.codegym.task.task25.task2514;

/* 
Finagle's first law: if an experiment succeeds, then something went wrong...

*/
public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);
        }
    }

    public static void main(String[] args) {
        Thread s=new Thread(new YieldRunnable(2));
        s.start();
    }
}
