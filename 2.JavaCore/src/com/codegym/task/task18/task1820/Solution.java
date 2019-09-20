package com.codegym.task.task18.task1820;

/* 
Rounding numbers

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        reader.close();

        BufferedReader r = new BufferedReader(new FileReader(file1));//otkrit file cherez buffer

        String[]chisl=r.readLine().split(" "); //schitat stroku i razbit ee
        int[] ch=new int[chisl.length];

        r.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
        for (int i=0;i<chisl.length;i++){
            ch[i]=(int)Math.round(Double.parseDouble(chisl[i]));

            bw.write(String.valueOf(ch[i]));
            if(i!=chisl.length-1)           //bez poslednego probela
            bw.write(" ");
        }

        bw.close();


    }
}
