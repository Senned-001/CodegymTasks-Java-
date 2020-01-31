package com.codegym.task.task18.task1817;

/* 
Spaces

*/

import java.io.FileInputStream;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        float count=0;
        int symbs=fileInputStream.available();
        while (fileInputStream.available()>0){
            int s=fileInputStream.read();
            if(s==32) count++;
        }
        fileInputStream.close();
        float f=count/symbs*100;
        DecimalFormat df = new DecimalFormat("###.##"); //fofmat vivoda chisla
        System.out.println(df.format(f));
    }
}
