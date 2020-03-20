package com.codegym.task.task36.task3603;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* 
Search for a class by its description

*/
public class Solution {
    public static void main(String... args) {    // This line is correct
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.remove("B");
        List<String> collection = Arrays.asList(new String[]{"B", "C", "D", "B"});
        list.addAllAbsent(collection);
        for (String string : list) {
            System.out.println(string);
        }
    }
}
