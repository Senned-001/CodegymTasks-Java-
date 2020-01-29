package com.codegym.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
A list and some threads

*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<>(5);

    public static void main(String[] args) {
        //write your code here
        SpecialThread t1 = new SpecialThread();
        SpecialThread t2 = new SpecialThread();
        SpecialThread t3 = new SpecialThread();
        SpecialThread t4 = new SpecialThread();
        SpecialThread t5 = new SpecialThread();

        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);
        Thread th3 = new Thread(t3);
        Thread th4 = new Thread(t4);
        Thread th5 = new Thread(t5);

        list.add(th1);
        list.add(th2);
        list.add(th3);
        list.add(th4);
        list.add(th5);
    }

    public static class SpecialThread implements Runnable {
        @Override
        public void run() {
            System.out.println("This is the run method inside SpecialThread");
        }
    }
}
