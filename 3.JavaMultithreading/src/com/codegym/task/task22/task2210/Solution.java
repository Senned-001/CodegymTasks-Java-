package com.codegym.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer

*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getTokens("level22.lesson13.task01", ".").toString());
    }
    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> ar=new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens()) {
            ar.add(tokenizer.nextToken());
        }
        String[] result = ar.toArray(new String[ar.size()]);
        return result;
    }
}
