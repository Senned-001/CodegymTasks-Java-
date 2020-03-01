package com.codegym.task.task27.task2712;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> listOfAllTablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        interval = interval;
        listOfAllTablets = tablets;
    }

    @Override
    public void run() {
        int x = (int) (Math.random()/(1.0/listOfAllTablets.size())-0.01);
        //System.out.println(listOfAllTablets.get(x));
        while (!Thread.currentThread().isInterrupted()) {
            listOfAllTablets.get(x).createTestOrder();
            try {
                Thread.currentThread().sleep(interval);
            } catch (InterruptedException e) {

            }
        }
    }
}
