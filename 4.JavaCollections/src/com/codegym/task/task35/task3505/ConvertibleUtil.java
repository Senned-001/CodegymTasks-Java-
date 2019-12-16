package com.codegym.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertibleUtil {

    public static <K,V extends Convertible>Map<K,V> convert(List<V> list) {

        Map<K,V> result = new HashMap();
        for(V v:list){
            K k= (K) v.getKey();
            result.put(k,v);
        }
        return result;
    }
}