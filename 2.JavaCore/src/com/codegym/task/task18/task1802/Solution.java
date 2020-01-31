package com.codegym.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Minimum byte

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream inputStream = new FileInputStream(name);
        int min = 255;
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if(min>data) min=data; //
        }
        inputStream.close();
        System.out.println(min);
    }
}

