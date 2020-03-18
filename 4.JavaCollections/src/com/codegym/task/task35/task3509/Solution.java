package com.codegym.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics

*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        //write your code here
        ArrayList<T> result=new ArrayList<>();
        for(T x:elements){
            result.add(x);
        }
        return result;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        //write your code here
        HashSet<T> result=new HashSet<>();
        for(T x:elements){
            result.add(x);
        }
        return result;
    }

    public static <K,V> HashMap<K,V> newHashMap(List<?  extends K> keys, List<? extends V> values) {
        //write your code here
        if(keys.size()!=values.size()) throw new IllegalArgumentException();
        else{
            HashMap<K,V>result=new HashMap<>();
            for(int i=0;i<keys.size();i++){
                result.put(keys.get(i),values.get(i));
            }
            return result;
        }
    }
}
