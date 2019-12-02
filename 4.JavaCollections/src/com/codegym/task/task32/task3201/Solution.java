package com.codegym.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Writing to an existing file

*/
public class Solution {
    public static void main(String... args) {
        try {
            RandomAccessFile randomAccessFile=new RandomAccessFile(args[0],"w");
            int number=Integer.parseInt(args[1]);
            String text=args[2];
            if(randomAccessFile.length()-number<text.length()) {
                randomAccessFile.seek(randomAccessFile.length());
                randomAccessFile.write(text.getBytes());
            }else{
                randomAccessFile.seek(number);
                randomAccessFile.write(text.getBytes());
            }
            randomAccessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
