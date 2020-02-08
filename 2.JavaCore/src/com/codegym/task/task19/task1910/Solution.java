package com.codegym.task.task19.task1910;

/* 
Punctuation

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();

        BufferedReader read = new BufferedReader(new FileReader(name1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(name2));
        String s="";
        while((s=read.readLine())!=null){
            String[]data=s.split("\\p{P}|\\n ");//znaki punktuacii ili simvol novoy stroki
            for(int i=0;i<data.length;i++){
                writer.write(data[i]);
            }
        }
        read.close();
        writer.close();
    }
}
