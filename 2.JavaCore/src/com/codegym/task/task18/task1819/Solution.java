package com.codegym.task.task18.task1819;

/* 
Combining files

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(file1);
        FileInputStream inputStream2 = new FileInputStream(file2);
        byte[]buffer1=new byte[inputStream.available()];
        inputStream.read(buffer1);
        byte[]buffer2=new byte[inputStream2.available()];
        inputStream2.read(buffer2);
        inputStream.close();
        inputStream2.close();

        FileOutputStream outputStream = new FileOutputStream(file1);
        outputStream.write(buffer2);
        outputStream.write(buffer1);
        outputStream.close();
    }
}
