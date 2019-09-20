package com.codegym.task.task08.task0801;

/* 
HashSet of plants

*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {
        HashSet<String> HashSet = new HashSet<String>();
        HashSet.add("watermelon");
        HashSet.add("banana");
        HashSet.add("cherry");
        HashSet.add("pear");
        HashSet.add("cantaloupe");
        HashSet.add("blackberry");
        HashSet.add("ginseng");
        HashSet.add("strawberry");
        HashSet.add("iris");
        HashSet.add("potato");

        for (String text : HashSet)
        {
            System.out.println(text);
        }
    }
}
