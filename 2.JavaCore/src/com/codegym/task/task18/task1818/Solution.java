package com.codegym.task.task18.task1818;

/* 
Two in one

*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(file2);
        FileInputStream inputStream2 = new FileInputStream(file3);
        FileOutputStream outputStream = new FileOutputStream(file1,true);
        while (inputStream.available()>0){
            outputStream.write(inputStream.read());
        }
        inputStream.close();
        while (inputStream2.available()>0){
            outputStream.write(inputStream2.read());
        }
        inputStream2.close();
        outputStream.close();
    }
}
