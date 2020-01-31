package com.codegym.task.task18.task1824;

/* 
Files and exceptions

*/

import java.io.*;

public class Solution {
    public static void main(String[] args)  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while(true) {
                String name = null;
                name = reader.readLine();
                try {
                    FileInputStream inputStream = new FileInputStream(name);
                    inputStream.close();
                } catch (FileNotFoundException e) {
                    System.out.println(name);
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
