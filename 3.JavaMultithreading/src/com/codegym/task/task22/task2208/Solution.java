package com.codegym.task.task22.task2208;

import java.util.*;

/* 
Build a WHERE query

*/
public class Solution {
    public static void main(String[] args) {
        Map<String,String>map=new HashMap<String, String>();
            map.put("name",null);
            map.put("country",null);
            map.put("city",null);
            map.put("age",null);
        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder WHERE = new StringBuilder();
        for(Map.Entry<String, String> x : params.entrySet()){
            if(x.getValue()!=null) {
                WHERE.append(x.getKey()+" = \'"+x.getValue()+"\' and ");
            }
        }
        String result = WHERE.toString();
        System.out.println(result);
        if(result.length()<5)
            return "";
        result=result.substring(0,result.length()-5);
        return result;
    }
}
