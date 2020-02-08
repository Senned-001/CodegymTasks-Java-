package com.codegym.task.task19.task1908;

/* 
Picking out numbers  (.*)(\\d+)(.*)

*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();

        FileReader read = new FileReader(name1);
        FileWriter writer = new FileWriter(name2);
        BufferedReader sc = new BufferedReader(read);
        String s="",line="";
        while ((line=sc.readLine())!=null) {
            String[] data = line.split(" ");
            for(int i=0;i<data.length;i++){
                try {
                    int b = Integer.parseInt(data[i]);
                    s=s+b+" ";
                } catch (Exception e) {
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(writer);
        read.close();
        sc.close();
        bw.write(s);
        bw.close();
        writer.close();
    }
}
