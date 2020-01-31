package com.codegym.task.task18.task1810;

/* 
DownloadException

*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String file1 = reader.readLine();
            FileInputStream inputStream = new FileInputStream(file1);
            if (inputStream.available() < 1000){
                reader.close();
                inputStream.close();
                throw new DownloadException();
        }
        }
    }

    public static class DownloadException extends Exception {

    }
}
