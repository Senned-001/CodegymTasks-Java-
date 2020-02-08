package com.codegym.task.task19.task1907;

/* 
Counting words

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        reader.close();

        FileReader read = new FileReader(name1);
        int kol=0;
       /*
        String word="";
        while (read.ready()){
            int data=read.read();
            if(((data>96)&&(data<123))) word=word+((char)data);
            else word="";
            if(word.equals("world")) kol++;
        }*/
        Scanner scanner = new Scanner(read);
        scanner.useDelimiter("\\W");
        while (scanner.hasNext()){
            String data = scanner.next();
            if (data.equals("world")) {
                kol++;
            }
        }
        read.close();
        System.out.println(kol);
    }
}
