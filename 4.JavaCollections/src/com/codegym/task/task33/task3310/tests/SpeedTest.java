package com.codegym.task.task33.task3310.tests;

import com.codegym.task.task33.task3310.Helper;
import com.codegym.task.task33.task3310.Shortener;
import com.codegym.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.codegym.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SpeedTest {

    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids)  {
        Date dateStart=new Date();
        for (String s : strings) {
            ids.add(shortener.getId(s));
        }
        Long timeToGetId = new Date().getTime()-dateStart.getTime();
        return timeToGetId;
    }
    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Date dateStart=new Date();
        for (Long l : ids) {
            strings.add(shortener.getString(l));
        }
        Long timeToGetStr = new Date().getTime()-dateStart.getTime();
        return timeToGetStr;
    }

    @Test
    public void testHashMapStorage(){
        Shortener shortener1= new Shortener(new HashMapStorageStrategy());
        Shortener shortener2= new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        for(int i = 0; i<10000;i++){
            origStrings.add(Helper.generateRandomString());
        }
        Set<Long> ids1=new HashSet<>();
        Set<Long> ids2=new HashSet<>();
        Long t1= getTimeToGetIds(shortener1,origStrings,ids1);
        Long t2= getTimeToGetIds(shortener2,origStrings,ids2);
        Assert.assertTrue(t1>t2);

        Set<String> str1 = new HashSet<>();
        Set<String> str2 = new HashSet<>();
        Long t3=getTimeToGetStrings(shortener1,ids1,str1);
        Long t4=getTimeToGetStrings(shortener2,ids2,str2);
        Assert.assertEquals(t3, t4, 30);
    }
}
