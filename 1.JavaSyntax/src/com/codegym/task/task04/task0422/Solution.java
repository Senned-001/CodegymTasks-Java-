package com.codegym.task.task04.task0422;

/* 
18+

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        if (age<18)
            System.out.println("Grow up a little more");
        reader.close();
    }
}
