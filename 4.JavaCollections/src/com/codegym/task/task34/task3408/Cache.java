package com.codegym.task.task34.task3408;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache =new WeakHashMap<>();   // TODO: Add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        // TODO: Add your code here
        V o;
        if(!cache.containsKey(key)) {
            o=(V)clazz.getConstructor(key.getClass()).newInstance(key); //get and run Constructor of class SomeValue(SomeKey myKey) with parameter key
            cache.put(key,o);
        }
        else o= cache.get(key);
        return o;
    }

    public boolean put(V obj) {
        // TODO: Add your code here
        int size=size();
        try {
            K key;
            Method method=obj.getClass().getDeclaredMethod("getKey");       //get method by name
            method.setAccessible(true);
            key=(K)method.invoke(obj);                                 //run method on object without param
            cache.put(key,obj);
            if(size>=size()) return false;                              //check adding
            return true;
        } catch (IllegalAccessException|InvocationTargetException|NoSuchMethodException e) {
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}