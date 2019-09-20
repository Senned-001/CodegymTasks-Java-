package com.codegym.task.task04.task0439;

/* 
Chain letter

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        for (int i =0; i<10;i++)
        System.out.println(name + " loves me.");

    }
}
