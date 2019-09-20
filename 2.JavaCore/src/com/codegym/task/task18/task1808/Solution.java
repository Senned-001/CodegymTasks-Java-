package com.codegym.task.task18.task1808;

/* 
Splitting a file

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
        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);
        FileOutputStream outputStream2 = new FileOutputStream(file3);
        int ind=inputStream.available();
        while (inputStream.available() > 0) //пока остались непрочитанные байты
        {   int data = inputStream.read();
            if(inputStream.available() >= ind/2)
                outputStream.write(data);
            else
                outputStream2.write(data);
        }

        inputStream.close();
        outputStream.close();
        outputStream2.close();
    }
}
