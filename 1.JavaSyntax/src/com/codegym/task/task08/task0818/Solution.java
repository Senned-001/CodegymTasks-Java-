package com.codegym.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Only for the rich

*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Watermelon",2500);
        map.put("Banana",400);
        map.put("Cherry",1000);
        map.put("Pear",300);
        map.put("Cantaloupe",500);
        map.put("Blackberry",400);
        map.put("Ginseng",1200);
        map.put("Strawberry",1000);
        map.put("Iris",450);
        map.put("Potato",3000);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        HashMap<String, Integer> rab = new HashMap<String, Integer>(map);
        for (HashMap.Entry<String, Integer> ent : rab.entrySet()) {
            if(ent.getValue()<500) map.remove(ent.getKey());
        }
    }

    public static void main(String[] args) {
    }
}