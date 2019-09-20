package com.codegym.task.task16.task1616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/* 
Counting seconds

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        // Create and run thread
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        // Read a string
        reader.readLine();
        stopwatch.interrupt();
        // Close streams
        reader.close();
        in.close();
    }

    public static class Stopwatch extends Thread {
        private int seconds;

        public void run() {
            try {
                while(true) {
                    Thread.sleep(1000);
                    seconds++;
                }

                //write your code here
            } catch (InterruptedException e) {
                System.out.println(seconds);
            }
        }
    }
}
