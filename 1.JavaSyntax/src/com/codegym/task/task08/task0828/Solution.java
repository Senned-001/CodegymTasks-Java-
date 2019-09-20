package com.codegym.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Month number

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1","January");
        map.put("2","February");
        map.put("3","March");
        map.put("4","April");
        map.put("5","May");
        map.put("6","June");
        map.put("7","July");
        map.put("8","August");
        map.put("9","September");
        map.put("10","October");
        map.put("11","November");
        map.put("12","December");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();

        for(HashMap.Entry<String, String> x : map.entrySet()){
            if(x.getValue().equals(month)) System.out.println(x.getValue() + " is month " + x.getKey());
        }

    }
}
