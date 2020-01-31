package com.codegym.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //write your code here
    static{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName=reader.readLine();
            secondFileName=reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //write your code here
        f.join();
        System.out.println(f.getFileContents());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContents();

        void join() throws InterruptedException;

        void start();
    }

    //write your code here
    public static class ReadFileThread extends Thread implements ReadFileInterface  {
        private ArrayList<String> result = new ArrayList<>();
        private String fn;

        @Override
        public void setFileName(String fullFileName){
            fn=fullFileName;
        }

        @Override
        public String getFileContents(){
            String s="";
            for (int i=0;i<result.size();i++){
                if(i<(result.size()-1))
                    s=s+(result.get(i)+" ");
                else
                    s=s+result.get(i);
            }
            return s;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fn));
                String t=reader.readLine();
                while (t!=null){
                    result.add(t);
                    t=reader.readLine();
                }
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
