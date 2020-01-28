package com.codegym.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Longest string

*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int max=0;
        strings = new ArrayList<String>();
        for(int i=0;i<5;i++)
            strings.add(reader.readLine());
        for(int i=0;i<5;i++)
            if (strings.get(i).length() >= max) {
                max=strings.get(i).length();
            }
        for(int i=0;i<5;i++)
                if(strings.get(i).length()== max)
                    System.out.println(strings.get(i));
        reader.close();
    }
}
