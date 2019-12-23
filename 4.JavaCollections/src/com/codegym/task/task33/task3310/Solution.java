package com.codegym.task.task33.task3310;

import com.codegym.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.codegym.task.task33.task3310.strategy.OurHashMapStorageStrategy;
import com.codegym.task.task33.task3310.strategy.StorageStrategy;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> result=new HashSet<>();
        for (String s : strings) {
            result.add(shortener.getId(s));
        }
        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> result=new HashSet<>();
        for (Long l : keys) {
            result.add(shortener.getString(l));
        }
        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> test=new HashSet<>();
        for(int i=0;i<elementsNumber;i++){
            test.add(Helper.generateRandomString());
        }
        Shortener shortener=new Shortener(strategy);


        Date dateStart=new Date();
        Set<Long> ids=getIds(shortener,test);
        Long timeToGetId = new Date().getTime()-dateStart.getTime();
        Helper.printMessage("Time to getIds: "+timeToGetId);


        dateStart=new Date();
        Set<String> strings=getStrings(shortener,ids);
        Long timeToGetStrings = new Date().getTime()-dateStart.getTime();
        Helper.printMessage("Time to getStrings: "+timeToGetStrings);
        //Set<String> getStringsByMethod =getStrings(shortener,ids);
        //strings.containsAll(getStringsByMethod)&&getStringsByMethod.containsAll(strings)
        if(strings.equals(test)) Helper.printMessage("The test passed.");
        else Helper.printMessage("The test failed.");
    }

    public static void main(String[] args) {
        StorageStrategy storageStrategy=new HashMapStorageStrategy();
        testStrategy(storageStrategy,10000L);
        StorageStrategy storageStrategy2=new OurHashMapStorageStrategy();
        testStrategy(storageStrategy2,10000L);
    }
}
