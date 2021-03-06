package com.codegym.task.task27.task2709;

public class ConsumerTask implements Runnable {
    private TransferObject transferObject;
    protected volatile boolean stopped;

    public ConsumerTask(TransferObject transferObject) {
        this.transferObject = transferObject;
        new Thread(this, "ConsumerTask").start();
    }

    @Override
    public void run() {
        synchronized (transferObject) {
            while (!stopped) {
                transferObject.get();
            }
        }
    }

    public void stop() {
        stopped = true;
    }
}