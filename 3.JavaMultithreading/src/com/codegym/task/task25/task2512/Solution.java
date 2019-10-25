package com.codegym.task.task25.task2512;

/* 
Charting our own course

*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        if(e.getCause()!=null) uncaughtException(t, e.getCause());
        System.out.println(e.toString());
    }

    public static void main(String[] args) {
        new Solution().uncaughtException(Thread.currentThread(),new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
