package com.codegym.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Changing the encoding

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Charset windows1251 = Charset.forName("Windows-1251");
        Charset UTF8 = Charset.forName("UTF-8");
        byte[] buffer = new byte[1000];
        FileInputStream in = new FileInputStream(args[0]);
        FileOutputStream out = new FileOutputStream(args[1]);
        in.read(buffer);
        String s = new String(buffer, windows1251);
        buffer = s.getBytes(UTF8);
        out.write(buffer);
        in.close();
        out.close();
    }
}
