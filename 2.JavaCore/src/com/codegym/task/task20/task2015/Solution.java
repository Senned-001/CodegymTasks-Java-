package com.codegym.task.task20.task2015;

import java.io.*;

/* 
Overriding serialization

*/
public class Solution implements Serializable, Runnable {
     private transient Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // Do something here, doesn't matter what.
    }

    /**
     Override serialization.
     To do this, you need to declare the following methods:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Now serialization/deserialization will work for our scenario :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        runner = new Thread(this);
        runner.start();
    }

    public static void main(String[] args) {
    }
}
