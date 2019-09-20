package com.codegym.task.task19.task1927;

/* 
Contextual advertising

*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        testString.printSomething();
        //Вызываем функцию, которая ничего не знает о наших манипуляциях


        //Преобразовываем записанные в наш ByteArray данные в строку
        String[] result = outputStream.toString().split("\\n");






        //Возвращаем все как было
        System.setOut(consoleStream);

        for(int i=0;i<result.length;i++){
            if(i%2==0&&i!=0) {
                System.out.println("CodeGym - online Java courses");
                System.out.println(result[i]);
            }
            else System.out.println(result[i]);
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
