package com.codegym.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //write your code here
        int size=0;
        for(K key:keySet()){
            size+=map.get(key).size();
        }
        return size;
    }

    @Override
    public V put(K key, V value) {
        //write your code here
        if(map.containsKey(key)){
            if(map.get(key).size()==repeatCount){
                map.get(key).remove(0);
                map.get(key).add(value);
                return map.get(key).get(map.get(key).size() - 2);
            }
            else {
                map.get(key).add(value);
                return map.get(key).get(map.get(key).size() - 2);
            }

        }
        else{
            List<V> val=new ArrayList<V>();
            val.add(value);
            map.put(key,val);
            return null;
        }
    }

    @Override
    public V remove(Object key) {
        //write your code here
        if (map.containsKey(key)) {
            if(map.get(key).size()>1){
                V value=map.get(key).get(0);
                map.get(key).remove(0);
                return value;
            }
            else {
                V value=map.get(key).get(0);
                map.remove(key);
                return value;
            }

        }
        else return null;
    }

    @Override
    public Set<K> keySet() {
        //write your code here
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //write your code here
        ArrayList<V>result=new ArrayList<>();
        for(K key:keySet()){
            result.addAll(map.get(key));
        }
        return result;
    }

    @Override
    public boolean containsKey(Object key) {
        //write your code here
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //write your code here
        for(K key:keySet()){
            if(map.get(key).contains(value)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}