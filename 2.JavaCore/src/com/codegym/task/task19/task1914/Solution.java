package com.codegym.task.task19.task1914;

/* 
Problem solving

*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        String[] res=result.split("\\s\\D\\s");
        int c=0;
        if(result.contains("-"))
            c=Integer.parseInt(res[0])-Integer.parseInt(res[1]);
        if(result.contains("+"))
            c=Integer.parseInt(res[0])+Integer.parseInt(res[1]);
        if(result.contains("*"))
            c=Integer.parseInt(res[0])*Integer.parseInt(res[1]);
        result=result+c;

        System.setOut(consoleStream);
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

