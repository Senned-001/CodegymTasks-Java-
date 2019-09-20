package com.codegym.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Remove and insert

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<5;i++)
            list.add(reader.readLine());
        for(int i=0;i<13;i++) {
            s = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            list.add(0,s);
        }
        for(int i=0;i<5;i++)
            System.out.println(list.get(i));
    }
}
