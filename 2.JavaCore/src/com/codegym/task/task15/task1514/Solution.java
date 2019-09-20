package com.codegym.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Static modifiers: part 1

*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<>();
    static {
        labels.put(13.5, "s");
        labels.put(12.0, "v");
        labels.put(11.8, "b");
        labels.put(14.6, "n");
        labels.put(15.4, "m");
    }
    public static void main(String[] args) {
        System.out.println(labels);
    }
}
