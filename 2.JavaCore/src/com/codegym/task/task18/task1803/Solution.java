package com.codegym.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Most frequent bytes

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(name);
        HashMap<Integer,Integer> t = new HashMap<>();
        int max =0;
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if(t.containsKey(data)) t.replace(data,t.get(data)+1);
                else t.put(data,1);
            if(t.get(data)>max) max=t.get(data);

        }
        inputStream.close();
        for (Map.Entry<Integer,Integer> entry : t.entrySet()) {
            if (entry.getValue().equals(max)) {
               System.out.print(entry.getKey()+" ");
            }
        }
    }
}
