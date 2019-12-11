package com.codegym.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);
        if(softReference!=null){
            return softReference.get();
        }else return null;
        //write your code here

    }

    public AnyObject put(Long key, AnyObject value) {
        SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
        AnyObject result=null;
        if(softReference!=null){
            result=softReference.get();
            softReference.clear();
        }
        return result;
        //write your code here
    }

    public AnyObject remove(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.remove(key);
        AnyObject result=null;
        if(softReference!=null){
            result=softReference.get();
            softReference.clear();
        }
        return result;
        //write your code here

    }
}