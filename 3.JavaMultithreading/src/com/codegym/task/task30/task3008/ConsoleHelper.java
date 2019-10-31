package com.codegym.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader buff = new BufferedReader (new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        String string="";
        try {
            string=buff.readLine();
        } catch (IOException e) {
            System.out.println("An error occurred while trying to enter text. Try again.");
            string=readString();
        }
        return string;
    }

    public static int readInt(){
        int a = 0;
        try {
            a=Integer.parseInt(readString());
        } catch (NumberFormatException e) {
            System.out.println("An error while trying to enter a number. Try again.");
            a=readInt();
        }
        return a;
    }

}
