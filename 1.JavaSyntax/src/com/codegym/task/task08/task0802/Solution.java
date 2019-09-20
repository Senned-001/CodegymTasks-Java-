package com.codegym.task.task08.task0802;

/* 
HashMap of 10 pairs

*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("watermelon","melon");
        map.put("banana","fruit");
        map.put("cherry","fruit");
        map.put("pear","fruit");
        map.put("cantaloupe","melon");
        map.put("blackberry","fruit");
        map.put("ginseng","root");
        map.put("strawberry","fruit");
        map.put("iris","flower");
        map.put("potato","tuber");
        for (HashMap.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getKey();                      //ключ
            String value = pair.getValue();                  //значение
            System.out.println(key + " - " + value);
        }



    }
}
