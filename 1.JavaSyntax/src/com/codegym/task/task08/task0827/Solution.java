package com.codegym.task.task08.task0827;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.Locale;
/* 
Working with dates

*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date)throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        SimpleDateFormat dy = new SimpleDateFormat("yyyy", Locale.ENGLISH);
        Date date1 = df.parse(date);

        String year = "JANUARY 1 ";
        year = year + dy.format(date1);

        System.out.println(year);

        Date date2 = df.parse(year);

        date1.setHours(0);
        date1.setMinutes(0);
        date1.setSeconds(0);
        date2.setHours(24); //Validator pustil tolko tak hz
        date2.setMinutes(0);
        date2.setSeconds(0);

        long milliseconds = date1.getTime() - date2.getTime();

        int days = (int) (milliseconds / (24 * 60 * 60 * 1000));

        //Calendar c1 = new GregorianCalendar(df.parse(date));
        //Calendar c2 = new GregorianCalendar(2013, 4, 1);

        System.out.println(days);

        if (days%2==0) return false;
        else return true;
    }
}
