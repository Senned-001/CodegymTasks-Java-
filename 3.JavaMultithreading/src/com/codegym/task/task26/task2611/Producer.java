package com.codegym.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable{
    private ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        Thread t=Thread.currentThread();
        for(int i=1;i<1000;i++){
            map.put(""+i,"Some text for "+i);
            try {
                wait(500);
            } catch (InterruptedException e) {
                System.out.println(t.getName()+" thread was terminated");
            }
        }
    }
}
