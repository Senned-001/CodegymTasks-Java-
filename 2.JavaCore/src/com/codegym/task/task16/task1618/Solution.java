package com.codegym.task.task16.task1618;

/* 
Another interruption

*/



public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //write your code here
        TestThread th = new TestThread();
        th.start();
        th.interrupt();

    }

    //write your code here
    public static class TestThread extends Thread{
        public void run(){

        }
    }
}