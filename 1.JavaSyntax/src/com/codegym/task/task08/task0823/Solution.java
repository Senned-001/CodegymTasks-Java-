package com.codegym.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/* 
Going national

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] l = s.toCharArray();
        int m=0;
        if(l[0]!=' ') {
            s = (""+l[0]).toUpperCase();
            m=1;
        }
        else
            s="";
        for(int i=m; i<l.length;i++){
            s=s+l[i];
            if(l[i]==' ') {
                String t=(""+l[i+1]).toUpperCase();
                s=s+t;
                i++;
            }
        }
        System.out.println(s);
        reader.close();
    }
}
