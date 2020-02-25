package com.codegym.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Writing our own ThreadFactory

*/
public class Solution {

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {

            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private synchronized static void emulateThreadFactory() {

        AmigoThreadFactory factory = new AmigoThreadFactory();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory{
        private static AtomicInteger fabricNumber = new AtomicInteger(0);//
        private AtomicInteger threadNumber = new AtomicInteger(1);
        private ThreadGroup current = Thread.currentThread().getThreadGroup();

        public AmigoThreadFactory() {
            fabricNumber.incrementAndGet();

        }

        @Override
        public Thread newThread(Runnable r) {
            Thread th=new Thread(current,r);
            th.setDaemon(false);
            th.setPriority(Thread.NORM_PRIORITY);
            th.setName(Thread.currentThread().getThreadGroup().getName()+"-pool-"+fabricNumber+"-thread-"+threadNumber.getAndIncrement());
            return th;
            //return new Thread(r,Thread.currentThread().getThreadGroup().getName()+"-pool-"+this.A+"-thread-"+this.B);
        }
    }
}
