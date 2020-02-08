package com.codegym.task.task19.task1926;

/* 
Mirror image

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        reader.close();

        BufferedReader read1f = new BufferedReader(new FileReader(name1));
        String data="";
        String res="";
        while ((data=read1f.readLine())!=null) {
            for(int i=data.length()-1;i>=0;i--){
                res=res+data.charAt(i);
            }
            //res=res+"\n";
            System.out.println(res);
            res="";
                    }
        read1f.close();
        //res=res.substring(0,res.length()-1);
    }
}
