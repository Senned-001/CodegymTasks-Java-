package com.codegym.task.task22.task2201;

/* 
Threads of a string or stringy threads? That's the question

*/
public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new OurUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName) {


        try {
            String s=string.substring(string.indexOf('\t')+1,string.lastIndexOf('\t'));
            return s;
        } catch (Exception e) {
            if(threadName.equals(FIRST_THREAD_NAME)) throw new StringForFirstThreadTooShortException();
            else if(threadName.equals(SECOND_THREAD_NAME)) throw new StringForSecondThreadTooShortException();
            else throw new RuntimeException();
        }

/*
        int i1=string.indexOf('\t');
        int i2=string.lastIndexOf('\t');
        if(i1<0||i2<0){
            if(threadName.equals(FIRST_THREAD_NAME)) throw new StringForFirstThreadTooShortException();
            else if(threadName.equals(SECOND_THREAD_NAME)) throw new StringForSecondThreadTooShortException();
            else throw new RuntimeException();
        }
        else string=string.substring(i1+1,i2);
        return string;*/
    }
}