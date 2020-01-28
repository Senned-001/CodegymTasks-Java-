package com.codegym.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Shortest or longest

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<10;i++) {
            list.add(reader.readLine());
        }
        int min=list.get(0).length();
        int max=0;
        for(int i=0;i<10;i++) {
            if (list.get(i).length() <= min)
                min = list.get(i).length();
        }
        for(int i=0;i<10;i++) {
            if (list.get(i).length() >= max)
                max = list.get(i).length();
        }
        for(int i=0;i<10;i++){
            if((list.get(i).length()==min)||(list.get(i).length()==max)) {
                System.out.println(list.get(i));
            }
            break;
        }
        reader.close();
    }
}
