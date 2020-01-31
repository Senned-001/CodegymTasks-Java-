package com.codegym.task.task18.task1821;

/* 
Symbol frequency 32-127

*/

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        FileInputStream inputStream = new FileInputStream(args[0]);
        HashMap<Character, Integer> count = new HashMap<>();
        while (inputStream.available()>0) {
            int i = inputStream.read();
            if (!count.containsKey((char)i))
                count.put((char)i,1);
            else {
                count.put((char)i,count.get((char)i)+1);
            }
        }
        inputStream.close();

        ArrayList<Character> sorted = new ArrayList<>(count.keySet());
        Collections.sort(sorted);
        for(int i = 0; i < sorted.size(); i++){
            System.out.println(sorted.get(i) + " " + count.get(sorted.get(i)));
        }
    }
}
