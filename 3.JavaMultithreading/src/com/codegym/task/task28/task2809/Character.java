package com.codegym.task.task28.task2809;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Character implements Runnable {
    protected abstract int getId();

    public void run() {
        System.out.println(toString() + " entered the game");
        doSomething();
        System.out.println(toString() + " died");
    }

    private void doSomething() {
        try {
            Thread.currentThread().sleep(ThreadLocalRandom.current().nextInt(10, 100));
        } catch (InterruptedException ignored) {
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " #" + getId();
    }

}
