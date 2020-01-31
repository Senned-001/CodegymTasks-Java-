package com.codegym.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Maximum byte

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream inputStream = new FileInputStream(name);
        int max = 0;
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if(max<data) max=data; //
        }
        inputStream.close();
        System.out.println(max);
    }
}
