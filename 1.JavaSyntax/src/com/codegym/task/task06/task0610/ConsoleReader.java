package com.codegym.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
ConsoleReader class

*/

public class ConsoleReader {
    public static String readString() throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        String s = bis.readLine();
        return s;
    }

    public static int readInt() throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(bis.readLine());
        return i;
    }

    public static double readDouble() throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        double d = Double.parseDouble(bis.readLine());
        return d;

    }

    public static boolean readBoolean() throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        boolean b=Boolean.valueOf(bis.readLine());
        return b;
    }

    public static void main(String[] args) {

    }
}
