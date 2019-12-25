package com.codegym.task.task33.task3310.tests;

import com.codegym.task.task33.task3310.Shortener;
import com.codegym.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    public void testStorage(Shortener shortener){
        String s1= "abcdefg";
        String s2= "zyxwvef";
        String s3= "abcdefg";
        Long l1=shortener.getId(s1);
        Long l2=shortener.getId(s2);
        Long l3=shortener.getId(s3);
        Assert.assertNotEquals(l2,l1);
        Assert.assertNotEquals(l2,l3);
        Assert.assertEquals(l1,l3);

        Assert.assertEquals(shortener.getString(l1),s1);
        Assert.assertEquals(shortener.getString(l2),s2);
        Assert.assertEquals(shortener.getString(l3),s3);
    }

    @Test
    public void testHashMapStorageStrategy(){
        Shortener shortener=new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy(){
        Shortener shortener=new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy(){
        Shortener shortener=new Shortener(new FileStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy(){
        Shortener shortener=new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy(){
        Shortener shortener=new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy(){
        Shortener shortener=new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(shortener);
    }
}
