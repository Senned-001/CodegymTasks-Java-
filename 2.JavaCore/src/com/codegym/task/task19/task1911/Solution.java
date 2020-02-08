package com.codegym.task.task19.task1911;

/* 
Reader wrapper

*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //remember real PrintStream in field
        PrintStream consoleStream = System.out;


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //create adapter for PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //set it as real System.out
        System.setOut(stream);

        testString.printSomething();
        //all data ByteArray into String
        String result = outputStream.toString().toUpperCase();

        //set real PrintStream again
        System.setOut(consoleStream);

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("This is text for testing");
        }
    }
}
