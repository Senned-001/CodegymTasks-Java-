package com.codegym.task.task07.task0710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
To the top of the list

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<String>();
        for(int i=0;i<10;i++) {
            strings.add(0, reader.readLine());
        }
        for(int i=0;i<10;i++) {
            System.out.println(strings.get(i));
        }
        reader.close();
    }
}
