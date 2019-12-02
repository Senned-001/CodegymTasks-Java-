package com.codegym.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Using RandomAccessFile

*/

public class Solution {
    public static void main(String... args) {
        try {
            RandomAccessFile randomAccessFile=new RandomAccessFile(args[0],"rw");
            int number=Integer.parseInt(args[1]);
            String text=args[2];
            randomAccessFile.seek(number);
            byte[] buffer=new byte[text.length()];
            randomAccessFile.read(buffer,0,text.length());
            randomAccessFile.seek(randomAccessFile.length());
            if(text.equals(new String(buffer))){
                randomAccessFile.write("true".getBytes());
            }else {
                randomAccessFile.write("false".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}