package com.codegym.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Searching for the right lines

*/

public class Solution {
    public static List<String> words = new ArrayList<>();

    static {
        words.add("file");
        words.add("view");
        words.add("In");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        reader.close();

        BufferedReader read1f = new BufferedReader(new FileReader(name1));
        String data="";
        while ((data=read1f.readLine())!=null){
            int count = 0;
            String[] res=data.split(" ");
            for(int i=0;i<res.length;i++){
                if(words.contains(res[i])) count++;
            }
            if(count==2) System.out.println(data);

        }
        read1f.close();
    }
}
