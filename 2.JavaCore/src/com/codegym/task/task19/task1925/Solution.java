package com.codegym.task.task19.task1925;

/* 
Long words

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
       BufferedReader read1f = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
        String data="";
        String result="";
        while ((data=read1f.readLine())!=null) {

            String[] res = data.split(" ");
            for (int i = 0; i < res.length; i++) {
                if (res[i].length() > 6) {
                    result=result+res[i]+",";
                }
            }
        }
        read1f.close();
        result=result.substring(0,result.length()-1);
        bw.write(result);
        bw.close();

    }
}
