package com.codegym.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    private TransferQueue<SharedItem> queue;

    public Consumer(TransferQueue<SharedItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(450);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.format("Processing %s\n", queue.take().toString());
            }
        } catch (InterruptedException e) {
            return;
        }

    }

}
