package com.codegym.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
        //write your code here
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t1.printResult();
        t2.printResult();
    }

    //write your code here
    public static class Read3Strings extends Thread{
        private ArrayList<String> result = new ArrayList<>();

        @Override
        public void run() {
            String t="";
            for(int i=0;i<3;i++) {
                try {
                    t=reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (t != null) {
                    result.add(t);}
            }

        }
        public void printResult(){
            for (int i=0;i<result.size();i++){
                if(i<(result.size()-1))
                    System.out.print(result.get(i)+" ");
                else
                    System.out.print(result.get(i));
            }
            System.out.println();
        }
    }
}
