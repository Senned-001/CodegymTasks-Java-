package com.codegym.task.task08.task0808;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* 
10 thousand deletions and insertions

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // ArrayList
        ArrayList <Integer> arrayList = new ArrayList<Integer>();
        insert10000(arrayList);
        get10000(arrayList);
        set10000(arrayList);
        remove10000(arrayList);

        // LinkedList
        LinkedList <Integer> linkedList = new LinkedList<Integer>();
        insert10000(linkedList);
        get10000(linkedList);
        set10000(linkedList);
        remove10000(linkedList);
    }

    public static void insert10000(List<Integer> list) {

        for(int i =0; i <10000; i++)
            list.add(i);

    }

    public static void get10000(List<Integer> list) {
        for(int i =0; i <10000; i++)
            list.get(i);

    }

    public static void set10000(List<Integer> list) {
        for(int i =0; i <10000; i++)
            list.set(i,i+1);

    }

    public static void remove10000(List<Integer> list) {
        list.removeAll(list);
        /*Iterator <Integer> listiterator = list.iterator();
        //Integer s = list.get(list.size()-1);
        while (!listiterator.hasNext())
            listiterator.remove();*/


       /* int i=0;
        for (Object x : list)  //быстрый for по всем элементам, только для коллекций
            if (i<10000) {list.remove(x);i++;}
            else break;*/

    }


}



