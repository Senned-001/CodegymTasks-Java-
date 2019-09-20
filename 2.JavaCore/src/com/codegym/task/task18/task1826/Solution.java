package com.codegym.task.task18.task1826;

/* 
Encryption

*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) throws Exception{

        FileInputStream inputStream = new FileInputStream(args[1]);
        FileOutputStream outputStream = new FileOutputStream(args[2]);

        if(args[0].equals("-e")){
            while(inputStream.available()>0){
                int data=inputStream.read()+3;
                outputStream.write(data);
            }
        }
        else if(args[0].equals("-d")){
            while(inputStream.available()>0){
                int data=inputStream.read()-3;
                outputStream.write(data);
            }
        }


        inputStream.close();
        outputStream.close();
    }

}
