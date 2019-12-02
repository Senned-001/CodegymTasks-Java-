package com.codegym.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Caesar cipher

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  // Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringWriter sw=new StringWriter();
        if(reader!=null) {
            BufferedReader bf = new BufferedReader(reader);
            char[] mas = bf.readLine().toCharArray();
            for (char x : mas) {
                x += key;
                sw.write(x);
            }
            return sw.toString();
        }
        else return "";
    }
}
