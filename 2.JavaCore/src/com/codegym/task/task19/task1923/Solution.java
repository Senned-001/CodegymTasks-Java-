package com.codegym.task.task19.task1923;

/* 
Words with numbers

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read1f = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
        String data="";

        while ((data=read1f.readLine())!=null) {

            String[] res = data.split(" ");
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].toCharArray().length; j++) {
                    if (Character.isDigit(res[i].toCharArray()[j])) {
                        bw.write(res[i] + " ");
                        break;
                    }
                }
            }
        }
        read1f.close();
        bw.close();
    }
}
