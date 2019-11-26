package com.codegym.task.task30.task3003;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/* 
Saving time

*/
public class Solution {
    /*
    1. Create a Producer class. To do this, click Alt+Enter -> Create Class... on the red class name.
    2. Point at the parameter name in the constructor (queue) and click Alt+Enter -> Create Field for Parameter 'queue' -> Enter -> Enter. The field name is queue.
    3. Point at the underlined class description. Then Alt+Enter -> Implement Methods -> Enter.
    4. Do items 1-3 for the Consumer class.
     */

    public static void main(String[] args) throws InterruptedException {
        TransferQueue<SharedItem> queue = new LinkedTransferQueue<>();

        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();

        Thread.sleep(1500);

        producer.interrupt();
        consumer.interrupt();
    }

}
