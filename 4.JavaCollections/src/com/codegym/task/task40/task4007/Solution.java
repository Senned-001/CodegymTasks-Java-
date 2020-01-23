package com.codegym.task.task40.task4007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/* 
Working with Java 8's DateTime API

*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //write your code here
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sDF= null;
        if(date.contains(".")&&date.contains(":")) {
            sDF = new SimpleDateFormat("d.M.yyyy H:m:s");
            try {
                calendar.setTime(sDF.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println("Day: " + calendar.get(Calendar.DATE));
            String dayOfWeek = ""+(calendar.get(Calendar.DAY_OF_WEEK) > 1 ? calendar.get(Calendar.DAY_OF_WEEK) - 1 : 7);    //monday(2)-1st day
            System.out.println("Day of the week: " + dayOfWeek);
            System.out.println("Day of the month: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("Day of the year: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Week of the month: " + calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Week of the year: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Month: " + (calendar.get(Calendar.MONTH)+1));       //compt start from 0
            System.out.println("Year: " + calendar.get(Calendar.YEAR));
            String AM_PM=calendar.get(Calendar.AM_PM)==0?"AM":"PM";
            System.out.println("AM or PM: " + AM_PM);
            System.out.println("Hour: " + calendar.get(Calendar.HOUR));
            System.out.println("Hour of the day: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Minutes: " + calendar.get(Calendar.MINUTE));
            System.out.println("Seconds: " + calendar.get(Calendar.SECOND));
        }
        else if(date.contains(".")) {
            sDF = new SimpleDateFormat("d.M.yyyy");
            try {
                calendar.setTime(sDF.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println("Day: " + calendar.get(Calendar.DATE));
            String dayOfWeek = ""+(calendar.get(Calendar.DAY_OF_WEEK) > 1 ? calendar.get(Calendar.DAY_OF_WEEK) - 1 : 7);    //monday(2)-1st day
            System.out.println("Day of the week: " + dayOfWeek);
            System.out.println("Day of the month: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("Day of the year: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Week of the month: " + calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Week of the year: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Month: " + (calendar.get(Calendar.MONTH)+1));
            System.out.println("Year: " + calendar.get(Calendar.YEAR));
        }
        else if(date.contains(":")) {
            sDF = new SimpleDateFormat("H:m:s");
            try {
                calendar.setTime(sDF.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String AM_PM=calendar.get(Calendar.AM_PM)==0?"AM":"PM";
            System.out.println("AM or PM: " + AM_PM);
            System.out.println("Hour: " + calendar.get(Calendar.HOUR));
            System.out.println("Hour of the day: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Minutes: " + calendar.get(Calendar.MINUTE));
            System.out.println("Seconds: " + calendar.get(Calendar.SECOND));
        }

    }
}
