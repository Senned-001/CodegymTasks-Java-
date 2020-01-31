package com.codegym.task.task18.task1816;

/* 
ABCs

*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int count=0;
        while (fileInputStream.available()>0){
            int s=fileInputStream.read();
            if((s>=65&&s<=90)||(s>=97&&s<=122))
                count++;
        }
        fileInputStream.close();
        System.out.println(count);
    }
}
