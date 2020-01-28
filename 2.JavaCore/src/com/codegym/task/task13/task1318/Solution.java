package com.codegym.task.task13.task1318;


import java.io.*;
import java.util.Scanner;

/* 
Reading a file

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname = reader.readLine();
        reader.close();
        InputStream inStream = new FileInputStream(fname);
        while (inStream.available() > 0) {
            System.out.print((char)inStream.read());
        }
        inStream.close();
        reader.close();
    }
}