package com.codegym.task.task18.task1807;

/* 
Counting commas

*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(name);
        int count=0;
        while (inputStream.available() > 0) //пока остались непрочитанные байты
        {
            int data = inputStream.read();
            if (data == 44) count++;
        }
        inputStream.close();
        System.out.println(count);
    }
}
