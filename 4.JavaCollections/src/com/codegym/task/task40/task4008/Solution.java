package com.codegym.task.task40.task4008;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/* 
Working with Java 8's DateTime API

*/

public class Solution {
    public static void main(String[] args) {
        printDate("9.10.2017 5:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //write your code here
        LocalDate localDate = null;
        LocalTime localTime = null;
        DateTimeFormatter dTF = null;
        if(date.contains(".")&&date.contains(":")) {
            dTF = DateTimeFormatter.ofPattern("d.M.yyyy H:m:s");
            localDate = LocalDate.parse(date,dTF);
            localTime = LocalTime.parse(date,dTF);
            System.out.println("Day: " + localDate.getDayOfMonth());
            //String dayOfWeek = ""+(calendar.get(Calendar.DAY_OF_WEEK) > 1 ? calendar.get(Calendar.DAY_OF_WEEK) - 1 : 7);    //monday(2)-1st day
            System.out.println("Day of the week: " + localDate.getDayOfWeek().getValue());
            System.out.println("Day of the month: " + localDate.getDayOfMonth());
            System.out.println("Day of the year: " + localDate.getDayOfYear());
            System.out.println("Week of the month: " + (localDate.getDayOfMonth()/7+1));
            System.out.println("Week of the year: " + (localDate.getDayOfYear()/7+1));
            System.out.println("Month: " + localDate.getMonthValue());
            System.out.println("Year: " + localDate.getYear());
            String AM_PM=localTime.getHour()<12?"AM":"PM";
            System.out.println("AM or PM: " + AM_PM);
            System.out.println("Hour: " + (localTime.getHour()>12?localTime.getHour()%12:localTime.getHour()));
            System.out.println("Hour of the day: " + localTime.getHour());
            System.out.println("Minutes: " + localTime.getMinute());
            System.out.println("Seconds: " + localTime.getSecond());
        }
        else if(date.contains(".")) {
            dTF = DateTimeFormatter.ofPattern("d.M.yyyy");
            localDate = LocalDate.parse(date,dTF);

            System.out.println("Day: " + localDate.getDayOfMonth());
            //String dayOfWeek = ""+(calendar.get(Calendar.DAY_OF_WEEK) > 1 ? calendar.get(Calendar.DAY_OF_WEEK) - 1 : 7);    //monday(2)-1st day
            System.out.println("Day of the week: " + localDate.getDayOfWeek().getValue());
            System.out.println("Day of the month: " + localDate.getDayOfMonth());
            System.out.println("Day of the year: " + localDate.getDayOfYear());
            System.out.println("Week of the month: " + (localDate.getDayOfMonth()/7+1));
            System.out.println("Week of the year: " + (localDate.getDayOfYear()/7+1));
            System.out.println("Month: " + localDate.getMonthValue());
            System.out.println("Year: " + localDate.getYear());
        }
        else if(date.contains(":")) {
            dTF = DateTimeFormatter.ofPattern("H:m:s");
            localTime = LocalTime.parse(date,dTF);

            String AM_PM=localTime.getHour()<12?"AM":"PM";
            System.out.println("AM or PM: " + AM_PM);
            System.out.println("Hour: " + (localTime.getHour()>12?localTime.getHour()%12:localTime.getHour()));
            System.out.println("Hour of the day: " + localTime.getHour());
            System.out.println("Minutes: " + localTime.getMinute());
            System.out.println("Seconds: " + localTime.getSecond());
        }
    }
}
