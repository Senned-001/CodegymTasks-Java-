package com.codegym.task.task19.task1906;

/* 
Even characters

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();

        FileReader read = new FileReader(name1);
        FileWriter writer = new FileWriter(name2);
        int i=1;
        while (read.ready()){  //пока есть непрочитанные байты в потоке ввода
            int data =read.read();
            if(i%2==0) writer.write(data);
            i++;
        }
        read.close();
        writer.close();
    }
}
