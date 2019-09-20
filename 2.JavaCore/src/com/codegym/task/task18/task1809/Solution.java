package com.codegym.task.task18.task1809;

/* 
Reversing a file

*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);
        byte[] buffer = new byte[inputStream.available()];

            for(int i=buffer.length-1;i>=0;i--){
                buffer[i]=(byte)inputStream.read();
            }
            outputStream.write(buffer);


        inputStream.close();
        outputStream.close();

    }
}
