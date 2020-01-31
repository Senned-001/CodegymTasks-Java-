package com.codegym.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new t1());
        threads.add(new t2());
        threads.add(new t3());
        threads.add(new t4());
        threads.add(new t5());
    }

    public static void main(String[] args) {
    }

    public static class t1 extends Thread{

        @Override
        public void run() {
            while (true) {
            }
        }
    }

    public static class t2 extends Thread{

        @Override
        public void run() {
            try {
                while(true){
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }

        }
    }

    public static class t3 extends Thread{

        @Override
        public void run() {
            try {
                while(true){
                    System.out.println("Hurray");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {

            }
        }
    }

    public static class t4 extends Thread implements Message{

        @Override
        public void showWarning(){
            this.interrupt();
        }

        @Override
        public void run() {
           while(!Thread.currentThread().isInterrupted()){}
        }
    }

    public static class t5 extends Thread{
        ArrayList <Integer> list = new ArrayList<>();

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String s=reader.readLine();
                while (!s.equals("N")){
                    list.add(Integer.parseInt(s));
                    s=reader.readLine();
                }
                int sum=0;
                for(int i=0;i<list.size();i++){
                    sum=sum+list.get(i);
                }
                System.out.println(sum);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}