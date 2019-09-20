package com.codegym.task.task19.task1909;

/* 
Changing punctuation marks

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

            writer.write(s.replace(".","!"));
        }
        read.close();
        writer.close();

    }
}
