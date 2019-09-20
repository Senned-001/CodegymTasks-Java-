package com.codegym.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;

/* 
Census

*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Watermelon","Serg");
        map.put("Banana","fruit");
        map.put("Cherry","fruit");
        map.put("Pear","Serg");
        map.put("Cantaloupe","melon");
        map.put("Blackberry","fruit");
        map.put("Ginseng","root");
        map.put("Strawberry","Serg");
        map.put("Iris","flower");
        map.put("Potato","tuber");
        return map;
    }

    public static int getSameFirstNameCount(HashMap<String, String> map, String name) {
        int count=0;
        for (String x : map.values()) {
            if (x.equals(name)) count++;
        }
        return count;
    }

    public static int getSameLastNameCount(HashMap<String, String> map, String lastName) {
        int count=0;
        for (String x : map.keySet()) {
            if (x.equals(lastName)) count++;
        }
        return count;

    }

    public static void main(String[] args) {

    }
}
