package com.codegym.task.task25.task2511;

import java.util.TimerTask;

/* 
Arming ourselves to the teeth!

*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler =new Thread.UncaughtExceptionHandler(){       // Init handler here
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String a=e.getMessage().replaceAll(t.getName(),t.getName().replaceAll(".","*"));

                System.out.println(a);
            }
        };
    }

    @Override
    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    @Override
    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    @Override
    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
    }
}