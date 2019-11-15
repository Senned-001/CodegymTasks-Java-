package com.codegym.task.task28.task2805;

public class MyThread extends Thread {
    static int index=0;

    {   //non-static block of code - running on time to initialization of object
        index++;
        if(index==11) index=1;
        int groupPrior=MyThread.this.getThreadGroup().getMaxPriority();

        if(groupPrior<index) {
            this.setPriority(groupPrior);
        }
        else {
            this.setPriority(index);
        }
    }

    public MyThread() {
    }

    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }


}
