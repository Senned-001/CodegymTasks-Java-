package com.codegym.task.task25.task2510;

/* 
Wait and see

*/
public class Solution extends Thread {

    public Solution() {
        this.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                if(e instanceof Error) System.out.println("Can't keep running");
                else if(e instanceof Exception) System.out.println("Needs handling");
                else if(e instanceof Throwable) System.out.println("Wait and see");
            }
        });
    }

    public static void main(String[] args) {
        //new Solution().uncaughtException(Thread.currentThread(),new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
