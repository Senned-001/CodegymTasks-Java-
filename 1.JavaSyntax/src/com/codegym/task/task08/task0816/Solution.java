package com.codegym.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/* 
Kind Emma and the summer holidays

*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));
        map.put("Stallon", df.parse("SEPTEMBER 1 1980"));
        map.put("Stallo", df.parse("JULY 1 1980"));
        map.put("Stall", df.parse("JANUARY 1 1980"));
        map.put("Stal", df.parse("FEBRUARY 1 1980"));
        map.put("Sta", df.parse("JUNE 15 1980"));
        map.put("St", df.parse("AUGUST 18 1980"));
        map.put("S", df.parse("MARCH 1 1980"));
        map.put("Stap", df.parse("APRIL 1 1980"));
        map.put("Stao", df.parse("JUNE 1 1980"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM", Locale.ENGLISH);
        //DateFormat dc = new SimpleDateFormat("d", Locale.ENGLISH);
        // Date beg = df.parse("JUNE 1");
        // Date end = df.parse("AUGUST 31");
        HashSet<String> keysToRemove = new HashSet<>();
        for (HashMap.Entry<String, Date> ent : map.entrySet()) {
            if (df.format(ent.getValue()).equals("June"))
                keysToRemove.add(ent.getKey());
            if (df.format(ent.getValue()).equals("July"))
                keysToRemove.add(ent.getKey());
            if (df.format(ent.getValue()).equals("August"))
                keysToRemove.add(ent.getKey());
        }
        map.keySet().removeAll(keysToRemove);
    }

    public static void main(String[] args) throws ParseException{
        removeAllSummerPeople(createMap());
    }
}
