package com.codegym.task.task19.task1927;

/* 
Contextual advertising

*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String[] result = outputStream.toString().split("\\n");

        System.setOut(consoleStream);
        for(int i=0;i<result.length;i++){
            if(i%2==0&&i!=0) {
                System.out.println("CodeGym - online Java courses");
                System.out.println(result[i]);
            }
            else
                System.out.println(result[i]);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
