package com.codegym.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
More Sam-I-Am

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        list.add(0,"Sam");
        list.add(1,"I");
        list.add(2,"Am");
        for(int i = 0;i<list.size();i=i+2) {
            list.add(i + 1, "Ham");
        }
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
        reader.close();
    }
}
