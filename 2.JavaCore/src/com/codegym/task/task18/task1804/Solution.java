package com.codegym.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Rarest bytes

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(name);
        HashMap<Integer, Integer> t = new HashMap<>();
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (t.containsKey(data)) t.replace(data, t.get(data) + 1);
            else t.put(data, 1);
        }
        inputStream.close();

        int min = 255;
        for (Map.Entry<Integer, Integer> entry : t.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> entry : t.entrySet()) {
            if (entry.getValue().equals(min)) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
