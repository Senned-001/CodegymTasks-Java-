package com.codegym.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Shared last names and first names

*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Watermelon","Serg");
        map.put("Banana","fruit");
        map.put("Cherry","fruit");
        map.put("Pear","Serg");
        map.put("Cantaloupe","melon");
        map.put("Blackberry","fruit");
        map.put("Banana","root");
        map.put("Strawberry","Serg");
        map.put("Iris","flower");
        map.put("Potato","tuber");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
