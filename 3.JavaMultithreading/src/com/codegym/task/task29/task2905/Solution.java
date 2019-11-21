package com.codegym.task.task29.task2905;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/* 
Weird bugs O_o

*/
public class Solution {
    final int NUMBER_OF_THREADS = 3; // 3 threads will process our queue
    final int MAX_BATCH_SIZE = 100; // We'll pull out 100 messages each

    private Logger logger = Logger.getLogger(Solution.class.getName());
    private BlockingQueue messageQueue = new LinkedBlockingQueue(); // This is where all the messages will be stored

    private BlockingQueue fakeDatabase = new LinkedBlockingQueue();

    public static void main(String[] args) throws InterruptedException {
        // Putting static modifiers all over the place is inappropriate, so we'll put all the data in fields,
        // and then we'll create an object and call its methods
        Solution solution = new Solution();

        solution.startCreatingMessages();

        solution.startPersistingMessages();

        Thread.sleep(100);
        solution.printResults();

        Thread.sleep(100);
        solution.printResults();

        Thread.sleep(100);
        solution.printResults();

        Thread.sleep(500);
        solution.printResults();
    }

    public void startCreatingMessages() {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    messageQueue.add(String.valueOf(i));
                }
            }
        }.start();
    }

    public void startPersistingMessages() {
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {

            new Thread() {
                private final Collection batch = new ArrayList(MAX_BATCH_SIZE);

                {
                    setDaemon(true);
                }

                @Override
                public void run() {
                    while (!messageQueue.isEmpty()) {
                        try {
                            messageQueue.drainTo(batch, MAX_BATCH_SIZE);
                            persistData(batch);
                            batch.clear();
                            Thread.sleep(1);
                        } catch (Throwable e) {
                            logger.log(Level.SEVERE, "Unable to persist batch", e);
                        }
                    }
                }
            }.start();
        }
    }

    private synchronized void persistData(Collection batch) {
        // Image that here we connect to a database and save the data in it
        // Saving data one entry at a time uses a lot of resources, so we'll do in batches (several at a time)
        fakeDatabase.addAll(batch);
    }

    private void printResults() {
        System.out.println();
        System.out.println("messageQueue size is " + messageQueue.size());
        System.out.println("fakeDatabase size is " + fakeDatabase.size());
    }
}