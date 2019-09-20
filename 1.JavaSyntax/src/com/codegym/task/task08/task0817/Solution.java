package com.codegym.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
We don't need repeats

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

    public static void removeFirstNameDuplicates(Map<String, String> map) {

        ArrayList <String> del =  new ArrayList<>();


        for (HashMap.Entry<String, String> s : map.entrySet())          //dvoinoi cikl po Hashmap
            for (HashMap.Entry<String, String> ss : map.entrySet()){
                if((!s.getKey().equals(ss.getKey()))&&(s.getValue().equals(ss.getValue()))&&(!del.contains(s.getValue()))) //esli kluchi ne ravni i znacheniya ravni i eche ne sodergatcya v liste na udalenie
                    del.add(ss.getValue());                                                                                 //to zanosim ih v list udaleniya
        }


        for(int i =0;i<del.size();i++){
            removeItemFromMapByValue(map,del.get(i));
        }

       // for (HashMap.Entry<String, String> ent : map.entrySet()) {
         //      System.out.println(ent.getKey() + " - " + ent.getValue());
       // }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        removeFirstNameDuplicates(createMap());
    }
}
