package com.codegym.task.task16.task1623;

/* 
Creating threads recursively

*/

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount=0;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread{
        public GenerateThread(){
            super(String.valueOf(++createdThreadCount));
            start();
        }

        @Override
        public void run() {
            if(createdThreadCount<count) {
                System.out.println(new GenerateThread());
            }
        }

        @Override
        public String toString() {
            return getName()+" created";
        }
    }
}
