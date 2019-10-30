package com.codegym.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
The whole world is a comedy

*/
public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        // Implement the logic here. Use the lock field

        if(lock.tryLock())
            try {
                actionIfLockIsFree();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        else actionIfLockIsBusy();
    }

    public void actionIfLockIsFree() {
    }

    public void actionIfLockIsBusy() {
    }
}